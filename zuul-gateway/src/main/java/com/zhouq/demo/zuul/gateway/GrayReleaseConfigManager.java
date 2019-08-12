package com.zhouq.demo.zuul.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create by zhouq on 2019/8/11
 *
 * 获取数据库的灰度发布信息.
 */
@Configuration
@EnableScheduling
public class GrayReleaseConfigManager {

    private Map<String, GrayReleaseConfig> grayReleaseConfigs = new ConcurrentHashMap<String, GrayReleaseConfig>();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Scheduled(fixedRate = 1000)
    private void refreshRoute() {
        //查询数据库,获取需要灰度发布信息

        List<GrayReleaseConfig> results = jdbcTemplate.query(
                "select * from gray_release_config",
                new BeanPropertyRowMapper<>(GrayReleaseConfig.class)
        );

        for (GrayReleaseConfig grayReleaseConfig : results) {
            grayReleaseConfigs.put(grayReleaseConfig.getPath(), grayReleaseConfig);
        }
    }

    public Map<String, GrayReleaseConfig> getGrayReleaseConfigs() {
        return grayReleaseConfigs;
    }

}
