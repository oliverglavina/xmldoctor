package com.oliverglavina.testmarand.entity.list;

import com.oliverglavina.testmarand.Request.DiseaseRequest;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Eyferann on 23. 08. 2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Diseases {

    @XmlElement(name= "disease")
    @Valid
    private List<DiseaseRequest> diseases;

    public List<DiseaseRequest> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<DiseaseRequest> diseases) {
        this.diseases = diseases;
    }
}
