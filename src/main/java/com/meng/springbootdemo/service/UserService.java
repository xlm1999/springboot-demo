package com.meng.springbootdemo.service;

import com.meng.springbootdemo.dao.UserMapper;
import com.meng.springbootdemo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public static Long userId = 100L;

    public void demo() {
        System.out.println("Insert--------------");

        for (int i = 1; i <= 100; i++) {
            User user = new User();
            user.setUserId(userId);
            System.out.println(userId);

            user.setAccount("Account" + i);
            user.setPassword("pass" + i);
            user.setUserName("name" + i);
            userId++;
            userMapper.insert(user);
            System.out.println("第" + i + "条");
        }
        System.out.println("over..........");
    }

    public User getUserInfoByUserId(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
