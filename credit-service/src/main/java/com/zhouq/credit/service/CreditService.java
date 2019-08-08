package com.zhouq.credit.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zhouq.credit.api.CreditApi;

@RestController
public class CreditService implements CreditApi {

    public String add(@PathVariable("userId") Long userId,
                      @PathVariable("credit") Long credit) {
        System.out.println("对用户【userId=" + userId + "】增加积分：" + credit);
        return "{'msg': 'success'}";
    }

}