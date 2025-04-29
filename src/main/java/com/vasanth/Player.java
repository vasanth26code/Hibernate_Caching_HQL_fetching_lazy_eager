package com.vasanth;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Player {

    @Id
    private int pid;
    private String pname;
    private String position;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> addresses;


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Player{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", position='" + position + '\'' +
                ", addresses=" + addresses +
                '}';
    }

}
