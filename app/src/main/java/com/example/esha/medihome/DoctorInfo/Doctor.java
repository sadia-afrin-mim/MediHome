package com.example.esha.medihome.DoctorInfo;

/**
 * Created by fatema on 11/8/17.
 */

public class Doctor {
    String doctorName;

    String doctorGenre;
    String doctorCatagory;
    String doctorPhone;

    public Doctor() {

    }


    public Doctor(String doctorName, String doctorGenre, String doctorCatagory, String doctorPhone) {
        this.doctorName = doctorName;

        this.doctorGenre = doctorGenre;
        this.doctorCatagory = doctorCatagory;
        this.doctorPhone = doctorPhone;

    }

    public String getDoctorName() {
        return doctorName;
    }


    public String getDoctorGenre() {
        return doctorGenre;
    }

    public String getDoctorCatagory() {
        return doctorCatagory;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }
}
