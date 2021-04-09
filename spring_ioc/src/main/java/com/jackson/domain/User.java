package com.jackson.domain;

import sun.dc.pr.PRError;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class User {
    private String username;
    private int age;

    private List<String> strings;
    private Map<Integer, String> map;
    private Properties properties;

    public User() { }

    public User(String username, int age, List<String> strings, Map<Integer, String> map, Properties properties) {
        this.username = username;
        this.age = age;
        this.strings = strings;
        this.map = map;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", strings=" + strings +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
