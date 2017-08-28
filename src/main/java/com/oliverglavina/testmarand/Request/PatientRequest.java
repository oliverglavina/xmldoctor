package com.oliverglavina.testmarand.Request;

import com.oliverglavina.testmarand.entity.list.Diseases;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Eyferann on 21. 08. 2017.
 */
@XmlRootElement(name= "patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientRequest {

    @NotNull(message = "missing patient id")
    @NotBlank(message = "empty patient id")
    private String id;

    @NotNull(message = "missing patient first name")
    @NotBlank(message = "empty patient first name")
    private String first_name;

    @NotNull(message = "missing patient last name")
    @NotBlank(message = "empty patient last name")
    private String last_name;

    @Valid
    private Diseases diseases;

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

    public Diseases getDiseases() {
        return diseases;
    }

    public void setDiseases(Diseases diseases) {
        this.diseases = diseases;
    }
}
