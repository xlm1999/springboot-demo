package com.meng.springbootdemo.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
public class TestTimer {
    @Scheduled(cron = "0/1 * * * * ?")
    public void test() {
        System.out.println("当前时间：" + new Date());
    }
}
