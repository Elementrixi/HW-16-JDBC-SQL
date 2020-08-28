package com.alpashaev.model;

import java.util.Objects;

public class Student {
    private long id;
    private String first_name;
    private String secound_name;
    private int age;
    private String city;

    public Student(long id, String first_name, String secound_name, int age, String city) {
        this.id = id;
        this.first_name = first_name;
        this.secound_name = secound_name;
        this.age = age;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecound_name() {
        return secound_name;
    }

    public void setSecound_name(String secound_name) {
        this.secound_name = secound_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                first_name.equals(student.first_name) &&
                secound_name.equals(student.secound_name) &&
                city.equals(student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, secound_name, age, city);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", secound_name='" + secound_name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
