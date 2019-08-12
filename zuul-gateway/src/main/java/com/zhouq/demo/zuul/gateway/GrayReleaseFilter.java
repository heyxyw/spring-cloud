package com.zhouq.demo.zuul.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.Random;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Create by zhouq on 2019/8/11
 */
@Configuration
public class GrayReleaseFilter extends ZuulFilter {

    @Autowired
    private GrayReleaseConfigManager grayReleaseConfigManager;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURI = request.getRequestURI();

        // http://localhost:9000/order/order?xxxx

        Map<String, GrayReleaseConfig> grayReleaseConfigs = grayReleaseConfigManager.getGrayReleaseConfigs();

        for (String path : grayReleaseConfigs.keySet()) {
            if (requestURI.contains(path)) {
                GrayReleaseConfig grayReleaseConfig = grayReleaseConfigs.get(path);
                if (grayReleaseConfig.getEnableGrayRelease() == 1) {
                    System.out.println(grayReleaseConfig.getServiceId() + ":启用了灰度发布...");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object run() {

        Random random = new Random();
        int seed = random.nextInt(100);

        if (seed == 50) {
            RibbonFilterContextHolder.getCurrentContext().add("version", "new");
        } else {
            RibbonFilterContextHolder.getCurrentContext().add("version", "current");
        }

        return null;
    }
}
