package com.xw.travelback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xingwang
 * @date 2020/11/10 21:02
 * @description
 */
@RestController
@RequestMapping("Health")
public class Health {

    @RequestMapping("Ok")
    public String oK() {
        return "OK";
    }
}
