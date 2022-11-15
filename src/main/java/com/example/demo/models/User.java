package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "age")
    @Min(value = 0, message = "Вы ввели отрицательный возраст")
    @Max(value = 122, message = "Рекорд 122 года. Я думаю вы моложе")
    private int age;

    public User(int id, String name, int age) {
        this.id = Long.valueOf(id);
        this.name = name;
        this.age = age;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = Long.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
