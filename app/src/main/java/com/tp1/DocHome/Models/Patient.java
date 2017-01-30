package com.tp1.DocHome.Models;

/**
 * Created by yyou on 2016/11/24.
 */

public class Patient {
    private Long id;
    private String password;
    private String lastName;
    private String firstName;
    private String sex;
    private long telephone;
    private String email;
    private String address;

    public Patient() {
    }

    public Patient(Long id, String password, String lastName, String firstName, String sex, long telephone, String email, String address) {
        this.id = id;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
