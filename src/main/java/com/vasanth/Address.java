package com.vasanth;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
//@Cacheable
public class Address {

    @Id
    private int aid;
    private int num;
    private String street;
    private String area;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", num=" + num +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

}
