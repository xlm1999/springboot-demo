package com.meng.springbootdemo.controller;

import com.meng.springbootdemo.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TestRestController {
    /**
     * 模拟一组数据
     */
    private List<User> getData() {
        List<User> list = new ArrayList<>();

        User userDO = new User();
        userDO.setUserId(1L);
        userDO.setUserName("admin");
        list.add(userDO);

        userDO = new User();
        userDO.setUserId(2L);
        userDO.setUserName("heike");
        list.add(userDO);

        userDO = new User();
        userDO.setUserId(3L);
        userDO.setUserName("tom");
        list.add(userDO);

        userDO = new User();
        userDO.setUserId(4L);
        userDO.setUserName("mac");
        list.add(userDO);

        return list;
    }

    /**
     * SELECT 查询操作，返回一个JSON数组
     * 具有幂等性
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Object getUsers() {
        List<User> list = new ArrayList<>();
        list = getData();
        return list;
    }

    /**
     * SELECT 查询操作，返回一个新建的JSON对象
     * 具有幂等性
     */
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(@PathVariable("id") String id) {

        if (null == id) {
            return null;
        }

        List<User> list = getData();
        User userDO = null;
        for (User user : list) {
            if (id.equals(user.getUserId().toString())) {
                userDO = user;
                break;
            }
        }

        return userDO;
    }

    /**
     * 新增一个用户对象
     * 非幂等
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addUser(@RequestBody User user) {

        List<User> list = getData();
        list.add(user);//模拟向列表中增加数据
        return user;
    }

    /**
     * 编辑一个用户对象
     * 幂等性
     */
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object editUser(@PathVariable("id") String id, @RequestBody User user) {
        List<User> list = getData();
        for (User userDO1 : list
        ) {
            if (id.equals(userDO1.getUserId().toString())) {
                userDO1 = user;
                break;
            }
        }

        return user;
    }

    /**
     * 删除一个用户对象
     * 幂等性
     */
    @RequestMapping(value = "/users/delete/{id}", method=RequestMethod.DELETE )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object deleteUser(@PathVariable("id") String id) {
        List<User> list = getData();
        User userDO = null;
        for (User user : list
        ) {
            if (id.equals(user.getUserId().toString())) {
                //删除用户
                userDO = user;
                break;
            }
        }
        return userDO;//返回被删除的对象
    }
}
