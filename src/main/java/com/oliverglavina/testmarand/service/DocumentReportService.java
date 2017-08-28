package com.oliverglavina.testmarand.service;

import com.oliverglavina.testmarand.entity.DocumentReport;
import com.oliverglavina.testmarand.repository.DocumentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Eyferann on 24. 08. 2017.
 */
@Service
public class DocumentReportService {

    @Autowired
    private DocumentReportRepository documentReportRepository;

    public List<DocumentReport> getAllReports(){
        return documentReportRepository.findAll();
    }

    public void addReport(Timestamp datetime, String doctorId, String error){
        DocumentReport report= new DocumentReport(datetime, doctorId, error);
        documentReportRepository.save(report);
    }
}
