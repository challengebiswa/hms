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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hms")
public class HospitalServiceController {

	@Autowired
	private SpecialistService specialistService;

	/**
	 * Check hospitalName and specialistType then get the result
	 * @param hospitalName
	 * @param specialistType
	 * @return SpecialistDetails
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/specialistDetails")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ResponseEntity<SpecialistDetails> getSpecialistDetails(@RequestParam("hospitalName") String hospitalName, @RequestParam("specialistType") String specialistType)
			throws ResourceNotFoundException {

		try {
			SpecialistDetails specialistDetails = specialistService.getSpecialistDetails(hospitalName, specialistType);
			return ResponseEntity.ok().body(specialistDetails);
		} catch (ResourceNotFoundException e) {
			throw e;
		}
	}

	/**
	 * Check specialistName,appointmentDay then get the AppointmentDetails details
	 * @param specialistName
	 * @param appointmentDay
	 * @param patientName
	 * @return AppointmentDetails
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/appointmentDetails")
	@Produces({ MediaType.APPLICATION_JSON })
	public ResponseEntity<AppointmentDetails> getAppoinmentDetails(@RequestParam("specialistName") String specialistName, @RequestParam("appointmentDay") String appointmentDay,
			@RequestParam("patientName") String patientName) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok()
					.body(specialistService.getAppointment(specialistName, appointmentDay, patientName));
		} catch (ResourceNotFoundException e) {
			throw e;
		}

	}
	
	/**
	 * Check hospital details and return no of beds available
	 * @param hospitalName
	 * @return String
	 * @throws ResourceNotFoundException
	 */

	@GetMapping("/bedDetails")
	public ResponseEntity<String> getBedDetails(@RequestParam("hospitalName") String hospitalName) throws ResourceNotFoundException {
		try {
			return ResponseEntity.badRequest().body(specialistService.getBedDetails(hospitalName));
		} catch (ResourceNotFoundException e) {
			throw e;
		}

	}

}
