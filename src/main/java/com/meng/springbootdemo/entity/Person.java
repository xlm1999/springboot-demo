package com.meng.springbootdemo.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Person {
    @NotEmpty(message = "姓名不能为空")
    @Length(min = 6, max = 12, message = "姓名长度必须位于6到12位之间")
    @Id
    private String personName;
    private Integer age;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public Person() {
    }
    public Person(String name, Integer age, String address) {
        this.personName = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + personName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
