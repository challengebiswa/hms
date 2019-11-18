package org.hms.serviceapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "doctor")
public class Doctor {

	private long id;
	private String name;
	@Column(name="hospital_id")
	private String hospitalId;
	@Column(name="type")
	private String type;	
	private String dateAvailable;
	private String timeAvailable;
	private Integer rate;
	private String status;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the hospitalId
	 */
	public String getHospitalId() {
		return hospitalId;
	}
	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
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
	 * @return the dateAvailable
	 */
	public String getDateAvailable() {
		return dateAvailable;
	}
	/**
	 * @param dateAvailable the dateAvailable to set
	 */
	public void setDateAvailable(String dateAvailable) {
		this.dateAvailable = dateAvailable;
	}
	/**
	 * @return the timeAvailable
	 */
	public String getTimeAvailable() {
		return timeAvailable;
	}
	/**
	 * @param timeAvailable the timeAvailable to set
	 */
	public void setTimeAvailable(String timeAvailable) {
		this.timeAvailable = timeAvailable;
	}
	/**
	 * @return the rate
	 */
	public Integer getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the createdOn
	 */
	@Column(name = "created_on")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name = "modified_on")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}	
	
	
	
}