package org.hms.serviceapp.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.hms.serviceapp.entity.Doctor;

@XmlRootElement (name="specialist")
public class Specialist {
	private String name;
	private String type;
	private String hospitalId;
	private String availableDay;
	private String availableTime;
	private Boolean isAvailable;
	
	public Specialist() {}
	/**
	 * @param name
	 * @param type
	 * @param hospotalId
	 * @param availableDay
	 * @param availableTime
	 * @param isAvailable
	 */
	public Specialist(Doctor doctor) {
		this.name = doctor.getName();
		this.type = doctor.getType();
		this.hospitalId = doctor.getHospitalId();
		this.availableDay = doctor.getDateAvailable();
		this.availableTime = doctor.getTimeAvailable();
		this.isAvailable = doctor.getStatus().equalsIgnoreCase("Y")?true:false;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the hospotalId
	 */
	public String getHospitalId() {
		return hospitalId;
	}
	/**
	 * @param hospotalId the hospotalId to set
	 */
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	/**
	 * @return the availableDay
	 */
	public String getAvailableDay() {
		return availableDay;
	}
	/**
	 * @param availableDay the availableDay to set
	 */
	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}
	/**
	 * @return the availableTime
	 */
	public String getAvailableTime() {
		return availableTime;
	}
	/**
	 * @param availableTime the availableTime to set
	 */
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	/**
	 * @return the isAvailable
	 */
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	

}
