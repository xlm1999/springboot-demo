package com.meng.springbootdemo.controller;

import com.meng.springbootdemo.entity.User;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public User index() {
        User user = new User();
        user.setUserId(2L);
        user.setUserName("haohao");
        return user;
    }

    @GetMapping(value = "/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public User xml() {
        User user = new User();
        user.setUserId(2L);
        user.setUserName("皓皓--");
        return user;
    }
}
