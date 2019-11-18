package org.hms.serviceapp.repository;

import java.util.List;

import org.hms.serviceapp.entity.Doctor;
import org.hms.serviceapp.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	@Query("select d from Doctor d where d.hospitalId = ?1 and d.type=?2")
	public List<Doctor> getSpecialistDoctorByHospital(String hospitalId,String specialistType) throws ResourceNotFoundException;
	
}