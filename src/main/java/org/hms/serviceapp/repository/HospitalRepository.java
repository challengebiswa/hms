package org.hms.serviceapp.repository;

import org.hms.serviceapp.entity.Hospital;
import org.hms.serviceapp.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, String>{

	@Query("select h from Hospital h where h.hospitalName = ?1")
	public Hospital getHospital(String hospitalName) throws ResourceNotFoundException;
}
