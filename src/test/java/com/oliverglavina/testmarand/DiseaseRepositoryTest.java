package com.oliverglavina.testmarand;

import com.oliverglavina.testmarand.entity.Disease;
import com.oliverglavina.testmarand.entity.Doctor;
import com.oliverglavina.testmarand.entity.Patient;
import com.oliverglavina.testmarand.repository.DiseaseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Eyferann on 27. 08. 2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DiseaseRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Test
    public void whenFindByPatientId_thenReturnDiseaseList(){
        Doctor doc= new Doctor("100", "marand");
        Patient oliver= new Patient("123", "Oliver", "Glavina", "100");
        Disease flu = new Disease("flu", "123");
        entityManager.persistAndFlush(doc);
        entityManager.persistAndFlush(oliver);
        entityManager.persistAndFlush(flu);

        List<Disease> search = diseaseRepository.findByPatientsId(oliver.getId());

        assertThat(search.get(0).getName()).isEqualTo(flu.getName());
    }
}
