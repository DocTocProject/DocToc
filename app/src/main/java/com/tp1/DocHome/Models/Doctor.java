package com.tp1.DocHome.Models;

/**
 * Created by yyou on 2016/11/10.
 */

public class Doctor {
    private Long id;
    private String password;
    private String lastName;
    private String firstName;
    private String address;
    private Point currentLocation;
    private char sex;
    private String fac;
    private Long telephone;
    private String email;
    private String photo;

    public Doctor() {
    }

    public Doctor(Long id, String password, String lastName, String firstName, String address, Point currentLocation, char sex, String fac, Long telephone, String email, String photo) {
        this.id = id;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.currentLocation = currentLocation;
        this.sex = sex;
        this.fac = fac;
        this.telephone = telephone;
        this.email = email;
        this.photo = photo;
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

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Point getCurrentLocation() { return currentLocation;}

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }
}