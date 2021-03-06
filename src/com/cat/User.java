package com.cat;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        id = UUID.randomUUID().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
