package com.meng.springbootdemo.controller;

import com.meng.springbootdemo.entity.Person;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


public class TestValidation {
    @PostMapping("/")
    public String test(@Valid Person person, BindingResult bindingResult) {
        StringBuffer stringBuffer = new StringBuffer();
        if(bindingResult.hasErrors()){
            List<ObjectError> list =bindingResult.getAllErrors();
            for (ObjectError objectError:list) {
                stringBuffer.append(objectError.getDefaultMessage());
                stringBuffer.append("---");
            }
        }
        return stringBuffer!=null?stringBuffer.toString():"";
    }
}
