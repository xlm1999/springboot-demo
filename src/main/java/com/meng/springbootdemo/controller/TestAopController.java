package com.meng.springbootdemo.controller;

import com.meng.springbootdemo.annotation.DoneTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAopController {
    @GetMapping("/index")
    @DoneTime(param = "IndexController")
    public String index(){
        System.out.println("方法执行");
        return "hello haohao1";
    }

    @GetMapping("/index2")
    public String index2(){
        System.out.println("方法2执行");
        return "hello haohao2";
    }
}
