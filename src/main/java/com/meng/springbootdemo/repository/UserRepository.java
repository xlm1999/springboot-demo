package com.meng.springbootdemo.repository;

import com.meng.springbootdemo.entity.House;
import com.meng.springbootdemo.entity.Person;
import com.meng.springbootdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person, Integer> {
}
