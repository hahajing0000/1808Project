package com.zy.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author:zhangyue
 * @date:2021/4/8
 */
public class Person implements Parcelable {
    private int age;
    private String name;

    public Person(){}

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    protected Person(Parcel in) {
        age = in.readInt();
        name = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
    }

    public void readFromParcel(Parcel dest){
        age=dest.readInt();
        name=dest.readString();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
