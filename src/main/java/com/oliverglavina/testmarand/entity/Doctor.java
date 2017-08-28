package com.oliverglavina.testmarand.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Eyferann on 18. 08. 2017.
 */
@Entity
public class Doctor {

    @Id
    private String id;

    private String department;

    public Doctor(){

    }

    public Doctor(String id, String department){
        super();
        this.id= id;
        this.department= department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
