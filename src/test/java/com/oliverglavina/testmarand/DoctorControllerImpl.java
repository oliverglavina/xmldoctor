package com.oliverglavina.testmarand;

import com.oliverglavina.testmarand.entity.Doctor;

import com.oliverglavina.testmarand.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Eyferann on 28. 08. 2017.
 */
@RestController
@RequestMapping("/doc")
public class DoctorControllerImpl {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(method= RequestMethod.GET, value="/doctors")
    public List<Doctor> findAllDoctors(){
        return doctorService.getAllDoctors();
    }
}
