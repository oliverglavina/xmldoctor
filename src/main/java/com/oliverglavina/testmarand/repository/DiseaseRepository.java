package com.oliverglavina.testmarand.repository;

import com.oliverglavina.testmarand.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Eyferann on 19. 08. 2017.
 */
@Repository
public interface DiseaseRepository extends JpaRepository<Disease, String> {

   List<Disease> findByPatientsId(String patientId);

}
