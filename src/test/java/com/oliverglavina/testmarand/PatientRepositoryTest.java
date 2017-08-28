package com.oliverglavina.testmarand;

import static org.assertj.core.api.Assertions.*;

import com.oliverglavina.testmarand.entity.Doctor;
import com.oliverglavina.testmarand.entity.Patient;
import com.oliverglavina.testmarand.repository.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Eyferann on 27. 08. 2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void whenFindByDoctorId_thenReturnPatient(){
        Doctor doc= new Doctor("100", "marand");
        Patient oliver= new Patient("123", "Oliver", "Glavina", "100");

        entityManager.persistAndFlush(doc);
        entityManager.persistAndFlush(oliver);

        List<Patient> search = patientRepository.findByDoctorId(doc.getId());

        assertThat(search.get(0).getId()).isEqualTo(oliver.getId());
        assertThat(search.get(0).getFirst_name()).isEqualTo(oliver.getFirst_name());
        assertThat(search.get(0).getLast_name()).isEqualTo(oliver.getLast_name());

    }

}
