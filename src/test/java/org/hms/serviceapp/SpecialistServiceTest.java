package org.hms.serviceapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hms.serviceapp.entity.SpecialistDtls;
import org.hms.serviceapp.entity.SpecialistDtls.SpecialistInformation;
import org.hms.serviceapp.exception.ResourceNotFoundException;
import org.hms.serviceapp.model.AppointmentDetails;
import org.hms.serviceapp.model.SpecialistDetails;
import org.hms.serviceapp.repository.DoctorRepository;
import org.hms.serviceapp.repository.HospitalRepository;
import org.hms.serviceapp.service.SpecialistService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class SpecialistServiceTest {

	@InjectMocks
	SpecialistService specialistService;
	
	@Mock
	SpecialistDtls specialistDtls;
	
	@Mock
	AppointmentDetails appointmentDetails;
	
	@Mock
	SpecialistInformation specialistInformation;
	

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		specialistService=new SpecialistService();
	}
	
	@Test
	public void testGetBedDetails() throws ResourceNotFoundException {
		specialistService=new SpecialistService();
		String beds=specialistService.getBedDetails("XYZ");
		String expect ="Number of Beds Available is = 2";
		assertEquals(expect, beds);
	}
	
	@Test
	public void testGetAppointment() throws ResourceNotFoundException {
		specialistDtls=new SpecialistDtls();
		specialistService=new SpecialistService(specialistDtls);
		appointmentDetails=specialistService.getAppointment("Edward", "Monday", "test");
		assertNull(appointmentDetails);
	}

	@Test
	public void testGetSpecialistDetails() {
		specialistService=new SpecialistService();
		SpecialistDetails specialistDetails=null;
		try {
			specialistDetails = specialistService.getSpecialistDetails("XYZ","Dentist");
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
		
	}
	
}
