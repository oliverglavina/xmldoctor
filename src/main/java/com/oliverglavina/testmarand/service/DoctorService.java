package com.oliverglavina.testmarand.service;

import com.oliverglavina.testmarand.Request.PatientRequest;
import com.oliverglavina.testmarand.entity.Doctor;
import com.oliverglavina.testmarand.entity.Patient;
import com.oliverglavina.testmarand.entity.list.Patients;
import com.oliverglavina.testmarand.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Eyferann on 24. 08. 2017.
 */
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientService patientService;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public void addDoctor(String id, String department, Patients patients){
        Doctor doc= new Doctor(id, department);
        doctorRepository.save(doc);

        if(patients != null) {
            for (PatientRequest patient : patients.getPatients()) {
                if(patient.getId()!=null) {
                    patientService.addPatient(patient.getId(), patient.getFirst_name(), patient.getLast_name(), id, patient.getDiseases());
                }
            }
        }
    }

}
