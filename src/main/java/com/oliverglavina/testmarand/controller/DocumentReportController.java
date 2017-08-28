package com.oliverglavina.testmarand.controller;

import com.oliverglavina.testmarand.entity.DocumentReport;
import com.oliverglavina.testmarand.service.DocumentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Eyferann on 24. 08. 2017.
 */
@RestController
public class DocumentReportController {
    @Autowired
    private DocumentReportService documentReportService;

    @RequestMapping(method= RequestMethod.GET, value="/reports")
    public List<DocumentReport> getAllReports(){
       return documentReportService.getAllReports();
    }
}
