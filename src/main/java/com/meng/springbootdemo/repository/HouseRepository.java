package com.meng.springbootdemo.repository;

import com.meng.springbootdemo.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Integer> {
}
