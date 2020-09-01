package com.meng.springbootdemo;

import com.meng.springbootdemo.entity.Person;
import org.junit.Test;

import java.io.*;

public class TestSerializable {
    @Test
    public void testVersion() throws Exception {
        File file = new File("person.out");
        // 序列化
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("Haozi", 22, "上海");
        oout.writeObject(person);
        oout.close();
        // 反序列化
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject();
        oin.close();
        System.out.println(newPerson);
    }
}
