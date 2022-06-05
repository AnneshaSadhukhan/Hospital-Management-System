package com.webservice.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import javax.transaction.Transactional;

import com.webservice.rest.controller.DoctorController;
import com.webservice.rest.controller.PatientController;
import com.webservice.rest.entity.Doctor;
import com.webservice.rest.entity.Patient;
import com.webservice.rest.repository.PatientRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RestApplicationTests 
{
	@Autowired
	private PatientRepository patrepo;
	@Test
	public void testCreatePatient() {
		Patient patient = new Patient(10,"Chanchal",27,"Anil",LocalDate.now(), "male","Chanchal.Prescription");
		patrepo.save(patient);
	}
	
	
	@Test
	public void testFindPatientById() {
		Integer id=13;
		patrepo.findById(id);
		//assertThat(patient.getId()).isEqualTo(id);
	}
	
	
	
	private Object assertThat(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PatientController patientController;

    @Autowired
     DoctorController doctorController;


    @Test
    public void test(){
        assertTrue(true);
    }
   /* @Test
    public void  showPatientInformationTest(){
        Patient patient =patientController.showPatientInformation(11);
        assertEquals(patient.getName(),"Abhishek shaw");
    }

    @Test
    public void showDoctorInformationTest(){
        Doctor doc = doctorController.getDoctorInfo("DR. POONAM JALAN"); 
        assertEquals(doc.getField(),"MBBS, MD - Venereology & Leprosy");
        // logger.info(doc.toString());
    }*/

    @Test
    @DirtiesContext
    @Transactional
    public void saveDoctorInformation(){
        Doctor doc = new Doctor("hello", 12, "male", "ent");
        boolean res=doctorController.addUser(doc);
        assertTrue(res);
    }

    @Test
    @DirtiesContext
    @Transactional
    public void savePatientInformation(){
        Patient patient = new Patient(1001, "hello", 30, "DR. POONAM JALAN",LocalDate.now(), "male", "xyz");
        /*boolean res = patientController.createPatient(patient);
        assertTrue(res);*/
        patientController.save(patient);
    }
}
