package com.misiai.domain;

public class User {
    private String username;
    private Integer age;

    private Address address;



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
