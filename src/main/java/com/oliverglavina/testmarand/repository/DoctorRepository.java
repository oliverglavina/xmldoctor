package com.oliverglavina.testmarand.repository;

import com.oliverglavina.testmarand.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Eyferann on 19. 08. 2017.
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,String> {

}
