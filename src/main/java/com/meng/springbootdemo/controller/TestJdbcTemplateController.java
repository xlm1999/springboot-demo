package com.meng.springbootdemo.controller;

import com.meng.springbootdemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class TestJdbcTemplateController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("query")
    @ResponseBody
    public String getUserByUserName() {
        String sql = "select * from user";
//        List<Person> list  = jdbcTemplate.query(sql,null);
        return "hello";
    }

    @GetMapping("deleteUserById")
    @ResponseBody
    public String deleteUserById(int id){
        int rows= jdbcTemplate.update("DELETE FROM  user  WHERE ID = ?",id);
        return "执行成功，影响"+rows+"行";
    }
}
