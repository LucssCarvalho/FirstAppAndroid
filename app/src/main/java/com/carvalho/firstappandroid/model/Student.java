package com.carvalho.firstappandroid.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String phone;
    private String email;
    private int id = 0;


    public Student(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Student(String nome) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() { return name; }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean hasValidId() {
        return id > 0;
    }
}
