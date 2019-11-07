package com.example.common;

import java.io.Serializable;


/*嘗試用一個共同的package 來做讓 app 和 getmessage 共用Person2，
因為app 的 Person2 和 getmessage 的 Person2 會被視為不一樣的東西
ps:  app 和 getmessage 都要先 implementation project(':common')
* */
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
