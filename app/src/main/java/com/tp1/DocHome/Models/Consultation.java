package com.tp1.DocHome.Models;
//import org.postgis.Point;
import java.util.Date;
import java.util.List;

/**
 * Created by reva on 11/10/2016.
 */


public class Consultation {

    private long id;
    
    Patient patient;
    
    Doctor doctor;
    
    private Date date;
    /*
    private Point place;*/
    
    private double price;

    
    private String diagnostic;
    //诊断 results

    
    private String prescription;
    //medicament recommendees 处方


    
    private List<Condition> condition;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    /*public Point getPlace() {
        return place;
    }
    public void setPlace(Point place) {
        this.place = place;
    }*/
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public List<Condition> getCondition() {
        return condition;
    }

    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }


    public long getDoctorId(long id){
        return doctor.getId();
    }

    public long getPatientId(long id){
        return patient.getId();
    }
}


