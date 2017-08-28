package com.oliverglavina.testmarand.controller;

import com.oliverglavina.testmarand.entity.Disease;
import com.oliverglavina.testmarand.repository.DiseaseRepository;
import com.oliverglavina.testmarand.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Eyferann on 19. 08. 2017.
 */
@RestController
public class DiseaseController {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private DiseaseService diseaseService;

    @RequestMapping(method = RequestMethod.GET, value="/diseases")
    public List<Disease> findAllDeseases(){
        return diseaseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="doctors/{doctorId}/patients/{patientId}/diseases")
    public List<Disease> findUserDiseases(@PathVariable String patientId){
        return diseaseRepository.findByPatientsId(patientId);
    }

}
