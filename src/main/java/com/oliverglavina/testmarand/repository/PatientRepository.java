package com.oliverglavina.testmarand.repository;

import com.oliverglavina.testmarand.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Eyferann on 19. 08. 2017.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient,String> {

    List<Patient> findByDoctorId(String doctorId);

}
