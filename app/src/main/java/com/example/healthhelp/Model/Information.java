package com.example.healthhelp.Model;

public class Information {
    int age;
    int height;
    int weight;
    String name;

    public Information(int age, int height, int weight, String name) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.name = name;
    }
    public Information(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}




