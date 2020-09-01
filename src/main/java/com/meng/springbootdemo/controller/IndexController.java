package com.meng.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController注解相当于@Controller和@ResponseBody的组合
//如果只是使用@RestController注解Controller，
//则Controller中的方法无法返回jsp页面，或者html，
// 配置的视图解析器 InternalResourceViewResolver不起作用，
// 返回的内容就是Return 里的内容。
@Controller
public class IndexController {

    @RequestMapping("/haohao")
    public String index() {
        return "hi haohao";
    }

    @RequestMapping("/test" )
    public String testThymeleaf(ModelMap modelMap){
        modelMap.addAttribute("msg", "Hello haohao , this is thymeleaf");
        return "thymeleaf";
    }

    @GetMapping(value = "/testJsp")
    public String testJsp(Model model){
        model.addAttribute("name","haohao");
        return "index1";
    }

    @RequestMapping("/testUploader")
    public String testUploader() {
        return "upload";
    }

}
