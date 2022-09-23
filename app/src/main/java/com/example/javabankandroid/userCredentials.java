package com.example.javabankandroid;


import android.widget.EditText;

public class userCredentials

{
    private String userName;
    private EditText phoneNumber;
    private String password;
    public userCredentials(String userName, EditText phoneNumber, String password)
    {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    public userCredentials()
    {

    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public EditText getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(EditText phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
