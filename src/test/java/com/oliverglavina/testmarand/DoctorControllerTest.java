package com.oliverglavina.testmarand;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.*;
import com.oliverglavina.testmarand.controller.DoctorController;
import com.oliverglavina.testmarand.entity.Doctor;
import com.oliverglavina.testmarand.service.DoctorService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import java.util.Arrays;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.List;

/**
 * Created by Eyferann on 27. 08. 2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = DoctorControllerImpl.class)
public class DoctorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DoctorService doctorService;

    @Test
    public void getDoctorsAndReturnJsonArray() throws Exception {

        Doctor doc = new Doctor("100", "marand");
        List<Doctor> allDoctors = Arrays.asList(doc);

        given(doctorService.getAllDoctors()).willReturn(allDoctors);

        mvc.perform(get("/doc/doctors")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].department", is(doc.getDepartment()))
        );

    }
}
