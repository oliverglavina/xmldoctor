package com.oliverglavina.testmarand.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eyferann on 19. 08. 2017.
 */
@Entity
public class Disease {

    @Id
    private String name;

    @ManyToMany
    private List<Patient> patients;

    public Disease(){

    }

    public Disease(String name, String patientId){
        super();
        this.name= name;
        this.patients= new ArrayList<Patient>();
        patients.add(new Patient(patientId,"","",""));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
