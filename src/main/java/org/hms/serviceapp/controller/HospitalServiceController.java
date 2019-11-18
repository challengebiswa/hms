package org.hms.serviceapp.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hms.serviceapp.exception.ResourceNotFoundException;
import org.hms.serviceapp.model.AppointmentDetails;
import org.hms.serviceapp.model.SpecialistDetails;
import org.hms.serviceapp.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hms")
public class HospitalServiceController {

	@Autowired
	private SpecialistService specialistService;

	@GetMapping("/specialistDetails")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ResponseEntity<SpecialistDetails> getSpecialistDetails(String hospitalName, String specialistType)
			throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok().body(specialistService.getSpecialistDetails(hospitalName, specialistType));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest()
					.body(specialistService.getSpecialistDetails(hospitalName, specialistType));
		}

	}

	@GetMapping("/appointmentDetails")
	@Produces({ MediaType.APPLICATION_JSON })
	public ResponseEntity<AppointmentDetails> getAppoinmentDetails(String specialistName, String appointmentDay,
			String patientName) throws ResourceNotFoundException {
		return ResponseEntity.badRequest()
				.body(specialistService.getAppointment(specialistName, appointmentDay, patientName));
	}

	@GetMapping("/bedDetails")
	public ResponseEntity<String> getBedDetails(String hospitalName) throws ResourceNotFoundException {
		return ResponseEntity.badRequest().body(specialistService.getBedDetails(hospitalName));
	}

}
