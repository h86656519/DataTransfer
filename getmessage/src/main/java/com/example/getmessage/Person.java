package com.example.getmessage;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Person implements Parcelable {
    private String name;
    private int ID;
    private String sex;

    public Person() {
    }

    public Person(String name, int ID, String sex) {
        this.name = name;
        this.ID = ID;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        // Parcel : 將指定的資料寫入包內( 您宣告的參數 )
        // 請依照順序擺放，不然無法對應到
        parcel.writeString(name); // String 型別
        parcel.writeString(sex);
        parcel.writeInt(ID); // int 型別
    }

    //    /**
//     * Creator
//     **/
    public static final Parcelable.Creator<Person> CREATOR = new Creator() {
        @Override
        public Person[] newArray(int size) {
            // Object 更改成您的 Class Name，並且將數量放置在生成的陣列數
            return new Person[size];
        }

        @Override
        public Person createFromParcel(Parcel parcel) {
            // 請依照順序擺放，不然無法對應到
            Person person = new Person();
            person.setName(parcel.readString());
            person.setSex(parcel.readString());
            person.setID(parcel.readInt());

            return person;
        }
    };
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getSEX() {
        return sex;
    }

    public static Parcelable.Creator<Person> getCREATOR() {
        return CREATOR;
    }
}
