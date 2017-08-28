package com.oliverglavina.testmarand.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oliverglavina.testmarand.Request.DoctorRequest;
import com.oliverglavina.testmarand.entity.Doctor;
import com.oliverglavina.testmarand.service.DoctorService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.oliverglavina.testmarand.service.DocumentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Eyferann on 19. 08. 2017.
 */
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DocumentReportService documentReportService;

    @RequestMapping(method= RequestMethod.GET, value="/doctors")
    public List<Doctor> findAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @RequestMapping(method= RequestMethod.POST, value="/doctors")
    public void addDoctor(@Valid @RequestBody DoctorRequest request, BindingResult bindingResult){
        HttpHeaders headers= new HttpHeaders();
        Timestamp timestamp= new Timestamp(System.currentTimeMillis());
        String docId= "null";
        String error;

        if (request.getId()!=null){
            docId= request.getId();
        }

        headers.setContentType(MediaType.TEXT_PLAIN);

        if(bindingResult.hasErrors()){
            error= "Code: " + HttpStatus.BAD_REQUEST.toString() + "; Message: ";
            for(ObjectError err : bindingResult.getAllErrors()){
                error+= err.getDefaultMessage() + ";";
            }
            documentReportService.addReport(timestamp, docId, error);
            return;
        }
        error= "Code: " + HttpStatus.OK.toString() + "; Message: Doctor added successfully";
        documentReportService.addReport(timestamp, docId, error);
        doctorService.addDoctor(request.getId(), request.getDepartment(), request.getPatients());
    }


}
