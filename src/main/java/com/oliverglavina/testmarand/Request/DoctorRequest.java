package com.oliverglavina.testmarand.Request;

import com.oliverglavina.testmarand.entity.list.Patients;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

/**
 * Created by Eyferann on 21. 08. 2017.
 */
@XmlRootElement(name= "doctor")
@XmlAccessorType(XmlAccessType.FIELD)
public class DoctorRequest {

    @XmlAttribute
    @NotNull(message = "missing doctor id")
    @NotBlank(message = "empty doctor id")
    private String id;

    @XmlAttribute
    @NotNull(message = "missing department")
    @NotBlank(message = "empty department")
    private String department;

    @Valid
    private Patients patients;

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

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }
}
