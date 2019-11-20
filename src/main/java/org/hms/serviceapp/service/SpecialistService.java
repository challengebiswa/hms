package org.hms.serviceapp.service;

import org.hms.cmnconst.CmnConst;
import org.hms.serviceapp.entity.Doctor;
import org.hms.serviceapp.entity.Hospital;
import org.hms.serviceapp.entity.HospitalDtls;
import org.hms.serviceapp.entity.Patient;
import org.hms.serviceapp.entity.SpecialistDtls;
import org.hms.serviceapp.entity.SpecialistDtls.SpecialistInformation;
import org.hms.serviceapp.exception.ResourceNotFoundException;
import org.hms.serviceapp.model.AppointmentDetails;
import org.hms.serviceapp.model.Specialist;
import org.hms.serviceapp.model.SpecialistDetails;
import org.hms.serviceapp.repository.DoctorRepository;
import org.hms.serviceapp.repository.HospitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialistService {

	private static final Logger logger = LoggerFactory.getLogger(SpecialistService.class);

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	SpecialistDetails specialists;

	@Autowired
	SpecialistDtls specialistDtls;

	@Autowired
	AppointmentDetails appointmentDetails;
	
	public SpecialistService() {
		// TODO Auto-generated constructor stub
	}
	
	public SpecialistService(SpecialistDtls specialistDtls) {
		// TODO Auto-generated constructor stub
		this.specialistDtls=specialistDtls;
	}

	@Cacheable("specialistDetails")
	public SpecialistDetails getSpecialistDetails(String hospitalName, String specialistType)
			throws ResourceNotFoundException {
		String errorMsg = null;
		try {
			Hospital hospital = hospitalRepository.getHospital(hospitalName);
			if (hospital != null) {
				List<Doctor> dList = doctorRepository.getSpecialistDoctorByHospital(hospital.getHospitalId(),
						specialistType);
				if (dList.size() == 0) {
					errorMsg = CmnConst.SPECIALIST_NOT_FOUND;
					throw new ResourceNotFoundException(errorMsg);
				}
				List<Specialist> specialistDetails = dList.stream().map(doctor -> {
					Specialist specialist = new Specialist(doctor);
					return specialist;
				}).collect(Collectors.toList());
				specialists.setSpecialistDetails(specialistDetails);
			} else {
				errorMsg = CmnConst.HOSPITAL_NOT_FOUND;
				throw new ResourceNotFoundException(errorMsg);
			}
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(errorMsg);
		}
		return specialists;
	}

	@Cacheable("appointmentDetails")
	public AppointmentDetails getAppointment(String specilist, String appointmentDay, String patientName)
			throws ResourceNotFoundException {
		List<SpecialistInformation> specialistNameList = specialistDtls.getSpecialistInformation();
		Integer counter = 0;
		for (SpecialistInformation specialistInformation : specialistNameList) {
			if (specialistInformation.getName().equalsIgnoreCase(specilist)) {
				counter++;
				String day[] = specialistInformation.getDay().split("[,]");
				if (Arrays.stream(day).anyMatch(appointmentDay::equalsIgnoreCase)) {
					appointmentDetails.setAppointmentDay(appointmentDay);
				} else {
					throw new ResourceNotFoundException(CmnConst.APPOINTMENT_DAY_NOT_FOUND);
				}
				appointmentDetails.setAppointmentTime(specialistInformation.getTime());
				appointmentDetails.setSpecialistName(specialistInformation.getName());
				appointmentDetails.setPatientName(patientName);
			} 
			if (counter == 0)
				throw new ResourceNotFoundException(CmnConst.SPECIALIST_NOT_FOUND);
		}
		return appointmentDetails;
	}

	public String getBedDetails(String hospitalName) throws ResourceNotFoundException {
		Integer counter = 0, hcounter = 0;
		List<HospitalDtls> hospitalDtlsList = getHospitalDtls();
		for (HospitalDtls hospitalDtls : hospitalDtlsList) {
			if (hospitalDtls.getHospitalName().equalsIgnoreCase(hospitalName)) {
				hcounter++;
				for (Patient patient : hospitalDtls.getPatientDtls()) {
					if (patient.getStatus().equalsIgnoreCase(CmnConst.DISCHARGE))
						counter++;
				}
			}
		}
		if (hcounter == 0) {
			throw new ResourceNotFoundException(CmnConst.HOSPITAL_NOT_FOUND);
		}
		if (counter == 0)
			throw new ResourceNotFoundException(CmnConst.BEDS_NOT_AVAILABLE);
		return "Number of Beds Available is = " + counter;
	}

	private List<HospitalDtls> getHospitalDtls() {
		List<HospitalDtls> hospitalDtlsList = new ArrayList<HospitalDtls>();
		HospitalDtls hospitalDtls1 = new HospitalDtls();
		hospitalDtls1.setHospitalName("ABC");
		List<Patient> patientList = new ArrayList<Patient>();
		Patient patient1 = new Patient();
		patient1.setName("test");
		patient1.setStatus("DISCHARGE");
		Patient patient2 = new Patient();
		patient2.setName("test1");
		patient2.setStatus("BLOCKED");
		patientList.add(patient1);
		patientList.add(patient2);
		hospitalDtls1.setPatientDtls(patientList);
		hospitalDtlsList.add(hospitalDtls1);

		HospitalDtls hospitalDtls2 = new HospitalDtls();
		hospitalDtls2.setHospitalName("XYZ");
		patientList = new ArrayList<Patient>();
		patient1 = new Patient();
		patient1.setName("test2");
		patient1.setStatus("DISCHARGE");
		patient2 = new Patient();
		patient2.setName("test3");
		patient2.setStatus("DISCHARGE");
		patientList.add(patient1);
		patientList.add(patient2);
		hospitalDtls2.setPatientDtls(patientList);
		hospitalDtlsList.add(hospitalDtls2);

		return hospitalDtlsList;
	}
}
