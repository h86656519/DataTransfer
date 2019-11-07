package com.example.datatransfer;

import android.os.Parcel;
import android.os.Parcelable;

//Parcelable 就是 Android 專用的序列化協定
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

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getSEX() {
        return sex;
    }


    @Override
    public int describeContents() {
        return 0;
    } // Person 物件裡又有其他物件就會用到這個

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
        public Person createFromParcel(Parcel parcel) { //parcel 就是0101...raw data
            // 請依照writeToParcel 裡寫入的順序擺放，不然無法對應到
            Person person = new Person();
            person.setName(parcel.readString());//5
            person.setSex(parcel.readString());//7
            person.setID(parcel.readInt());//4

            return person;
        }

        // name 1010 sex 0010101 id 0010 // Serializable 背後資料的樣子
        //  1010  0010101  0010 // Parcelable 背後資料的樣子，少了name id...所以比 Serializable 更小，所以更快，如果物件本身容量太小的話用Serializable 和 Parcelable的差別不大，反之

    };

    public static Parcelable.Creator<Person> getCREATOR() {
        return CREATOR;
    }
}
