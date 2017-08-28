package com.oliverglavina.testmarand.controller;

import com.oliverglavina.testmarand.entity.Patient;
import com.oliverglavina.testmarand.repository.PatientRepository;
import com.oliverglavina.testmarand.service.PatientService;
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
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @RequestMapping(method= RequestMethod.GET, value="/patients")
    public List<Patient> findAllPatients(){
        return patientRepository.findAll();
    }

    @RequestMapping(method= RequestMethod.GET, value="doctors/{doctorId}/patients")
    public List<Patient> getDoctorPatients(@PathVariable String doctorId){
        return patientRepository.findByDoctorId(doctorId);
    }

    @RequestMapping(method= RequestMethod.GET, value="doctors/{doctorId}/patients/{patientId}")
    public Patient getPatient(@PathVariable String patientId){
        return patientService.getPatient(patientId);
    }

}
