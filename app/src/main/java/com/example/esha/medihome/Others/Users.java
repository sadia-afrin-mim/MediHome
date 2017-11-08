package com.example.esha.medihome.Others;

/**
 * Created by esha on 24/10/17.
 */

public class Users {
    private String username;

    private String email;
    private String phone;
    public Users()
    {

    }
    public Users(String username, String email, String phone)
    {

        this.username=username;

        this.email=email;
        this.phone=phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
 //app:srcCompat="@android:drawable/sym_def_app_icon"