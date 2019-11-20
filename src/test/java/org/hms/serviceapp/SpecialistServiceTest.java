package org.hms.serviceapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hms.serviceapp.entity.SpecialistDtls;
import org.hms.serviceapp.entity.SpecialistDtls.SpecialistInformation;
import org.hms.serviceapp.exception.ResourceNotFoundException;
import org.hms.serviceapp.model.AppointmentDetails;
import org.hms.serviceapp.service.SpecialistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		specialistService=new SpecialistService();
	}
	
	@Test
	public void testGetBedDetails() throws ResourceNotFoundException {
		String beds=specialistService.getBedDetails("XYZ");
		String expect ="Number of Beds Available is = 2";
		assertEquals(expect, beds);
	}
}
