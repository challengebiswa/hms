package org.hms.serviceapp.entity;

import java.util.List;

public class HospitalDtls {

	private String hospitalName;
	private List<Patient> patientDtls;
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public List<Patient> getPatientDtls() {
		return patientDtls;
	}
	public void setPatientDtls(List<Patient> patientDtls) {
		this.patientDtls = patientDtls;
	}
	
	
}
