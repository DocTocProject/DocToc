package com.tp1.DocHome.Models;

/**
 * Created by reva on 11/10/2016.
 */


public class Condition {

    
    private long id;
    
    private String type;
    
    private int value;
    
    private Consultation consultation;

    public String getType() {
return type;
    }

    public void setType(String type) {
this.type = type;
    }

    public int getValue() {
return value;
    }

    public void setValue(int value) {
this.value = value;
    }

    public long getId() {
return id;
    }

    public void setId(long id) {
this.id = id;
    }

    public Consultation getConsultation() {
return consultation;
    }

    public void setConsultation(Consultation consultation) {
this.consultation = consultation;
    }
}
