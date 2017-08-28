package com.oliverglavina.testmarand.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Eyferann on 19. 08. 2017.
 */
@Entity
public class Patient {

    @Id
    private String id;

    private String first_name;

    private String last_name;

    @ManyToOne
    private Doctor doctor;

    public Patient(){

    }

    public Patient(String id, String first_name, String last_name, String doctorId){
        super();
        this.id= id;
        this.first_name= first_name;
        this.last_name= last_name;
        this.doctor= new Doctor(doctorId,"");
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
