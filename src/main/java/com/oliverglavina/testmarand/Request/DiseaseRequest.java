package com.oliverglavina.testmarand.Request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by Eyferann on 23. 08. 2017.
 */
@XmlRootElement(name= "disease")
@XmlAccessorType(XmlAccessType.FIELD)
public class DiseaseRequest {

    @XmlValue
    @NotNull(message = "missing disease name")
    @NotBlank(message = "empty disease name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
