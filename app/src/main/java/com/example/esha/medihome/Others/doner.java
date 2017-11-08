package com.example.esha.medihome.Others;

/**
 * Created by fatema on 11/8/17.
 */

public class doner {
    String name,bloodgroup,mobile,email,address,lastdon;

    public String getName() {
        return name;
    }


    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getLastdon() {
        return lastdon;
    }

    public doner(String name, String bloodgroup, String mobile, String email, String address, String lastdon) {
        this.name = name;
        this.bloodgroup = bloodgroup;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.lastdon = lastdon;
    }

    public doner() {

    }
}