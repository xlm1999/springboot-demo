package com.meng.springbootdemo.controller;

import com.meng.springbootdemo.entity.House;
import com.meng.springbootdemo.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {
    @Autowired
    private HouseRepository houseRepository;

    //http://localhost:8888/saveHouse?id=1&houseName=别墅&houseSize=1220平方米
    @GetMapping("/saveHouse")
    @CachePut(value = "house", key = "#id")
    public House saveHouse(Integer id, String houseName, String houseSize){
        House house = new House(id,houseName, houseSize);
        houseRepository.save(house);
        return house;
    }

    //http://localhost:8888/queryHouse?id=1
    @GetMapping("/queryHouse")
    @Cacheable(value = "house", key = "#id")
    public House queryHouse(Integer id){
        House house = houseRepository.findById(id).get();
        return house;
    }

    //http://localhost:8888/deleteHouse?id=1
    @GetMapping("/deleteHouse")
    @CacheEvict(value = "house", key = "#id")
    public String deleteHouse(Integer id){
        houseRepository.deleteById(id);
        return "success";
    }

    //http://localhost:8888/deleteCache
    @GetMapping("/deleteCache")
    @CacheEvict(value = "house", allEntries = true)
    public void deleteCache() {
    }

    @GetMapping("/test1")
    public String test1(){
        houseRepository.save(new House("house1", "100平方米"));
        houseRepository.save(new House("house2", "100平方米"));
        houseRepository.save(new House("house3", "100平方米"));
        houseRepository.save(new House("house444444444", "100平方米"));
        houseRepository.save(new House("house5", "100平方米"));
        return "success";
    }

    @GetMapping("/test2")
    @Transactional
    @Lazy
    public String test2(){
        houseRepository.save(new House("house6", "100平方米"));
        houseRepository.save(new House("house7", "100平方米"));
        houseRepository.save(new House("house8", "100平方米"));
        houseRepository.save(new House("house9", "100平方米"));
        houseRepository.save(new House("house10", "100平方米"));
        return "success";
    }

}
