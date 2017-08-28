package com.oliverglavina.testmarand.entity.list;


import com.oliverglavina.testmarand.Request.PatientRequest;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Eyferann on 21. 08. 2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Patients {

    @XmlElement(name= "patient")
    @Valid
    private List<PatientRequest> patients;

    public List<PatientRequest> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientRequest> patients) {
        this.patients = patients;
    }
}
