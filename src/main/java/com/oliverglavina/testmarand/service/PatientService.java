package com.oliverglavina.testmarand.service;

import com.oliverglavina.testmarand.Request.DiseaseRequest;
import com.oliverglavina.testmarand.entity.Patient;
import com.oliverglavina.testmarand.entity.list.Diseases;
import com.oliverglavina.testmarand.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Eyferann on 24. 08. 2017.
 */
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DiseaseService diseaseService;



    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatient(String id){
       return patientRepository.findOne(id);
    }

    public void addPatient(String id, String first_name, String last_name, String doctorId, Diseases diseases){
        Patient pat = new Patient(id,first_name,last_name,doctorId);
        patientRepository.save(pat);

        if(diseases != null) {
            for (DiseaseRequest disease : diseases.getDiseases()) {
                if(disease.getName()!=null) {
                    diseaseService.addDisease(disease.getName(), id);
                }
            }
        }
    }
}
