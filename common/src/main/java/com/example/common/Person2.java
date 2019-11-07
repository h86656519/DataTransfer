package com.example.common;

import java.io.Serializable;

public class Person2 implements Serializable {
    private String name;
    private int ID;
    private String sex;

    public Person2(String name, int ID, String sex) {
        this.name = name;
        this.ID = ID;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
