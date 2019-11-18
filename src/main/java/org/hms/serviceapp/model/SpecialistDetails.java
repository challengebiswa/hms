package org.hms.serviceapp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement
public class SpecialistDetails {
	
	//@XmlElementWrapper(name = "specialist")
	//@XmlElement(name = "specialist")
	private List<Specialist> specialistDetails;

	/**
	 * @return the specialistDetails
	 */
	public List<Specialist> getSpecialistDetails() {
		return specialistDetails;
	}

	/**
	 * @param specialistDetails the specialistDetails to set
	 */
	public void setSpecialistDetails(List<Specialist> specialistDetails) {
		this.specialistDetails = specialistDetails;
	}
	
	
}
