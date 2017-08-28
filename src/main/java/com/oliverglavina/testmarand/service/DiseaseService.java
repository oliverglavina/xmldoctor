package com.oliverglavina.testmarand.service;

import com.oliverglavina.testmarand.entity.Disease;
import com.oliverglavina.testmarand.entity.Patient;
import com.oliverglavina.testmarand.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Eyferann on 24. 08. 2017.
 */
@Service
public class DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    public List<Disease> getAllDiseases(){
        return diseaseRepository.findAll();
    }

    public Disease getDisease(String id){
        return diseaseRepository.findOne(id);
    }

    public void addDisease(String name, String patientId){
        Disease dis = diseaseRepository.findOne(name);
        //check if disease exists
        if(dis== null){
            dis= new Disease(name,patientId);
            diseaseRepository.save(dis);
        }//check if patients key is already present
        else if(!chkPatients(patientId, dis.getPatients())){
            List<Patient> patients= dis.getPatients();
            patients.add(new Patient(patientId,"","",""));
            dis.setPatients(patients);
            diseaseRepository.save(dis);
        }

    }

    public boolean chkPatients(String id, List<Patient> patients){
        for(Patient patient : patients){
            if(patient.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
