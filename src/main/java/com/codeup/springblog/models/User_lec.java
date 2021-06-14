package com.codeup.springblog.models;

public class User_lec {

    private String firstName;
    private String lastName;



    public User_lec(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User_lec() {
    }

    public String getFullName(){
        return this.firstName + ", " + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

