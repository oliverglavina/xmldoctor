package com.oliverglavina.testmarand.repository;

import com.oliverglavina.testmarand.entity.DocumentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Eyferann on 24. 08. 2017.
 */
@Repository
public interface DocumentReportRepository extends JpaRepository<DocumentReport, String> {

}
