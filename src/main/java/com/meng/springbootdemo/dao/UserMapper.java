package com.meng.springbootdemo.dao;

import com.meng.springbootdemo.entity.User;

public interface UserMapper {
    int insert(User record);
    int insertSelective(User record);
    User selectByPrimaryKey(Long userId);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);

}
