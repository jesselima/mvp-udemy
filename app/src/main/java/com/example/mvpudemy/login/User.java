package com.example.mvpudemy.login;

/**
 * Created by JesseFariasdeLima on 3/6/2019.
 * This is a part of the project mvp-udemy.
 */
public class User {

    private int id;
    private String firstName;
    private String lastName;


    public User(String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
