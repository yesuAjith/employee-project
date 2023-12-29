package com.employeereport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeereport.entity.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{

	@Query(value = "SELECT * FROM employee_details s WHERE s.emp_name=:name", nativeQuery = true)
	public List <EmployeeDetails> getByName(String name);
	
	@Query(value = "SELECT * FROM employee_details s WHERE s.emp_location=:location", nativeQuery = true)
	public List<EmployeeDetails>getByLocation(String location);
	
	@Query(name="showbyphone")
	public EmployeeDetails getByPhoneNumber(Long phone);
	
	@Query(value = "SELECT e.emp_id, e.emp_name, e.emp_email, "
			+ "e.emp_phone, e.emp_location, a.add_id, a.add_city, "
			+ "a.add_state FROM employee_details e "
			+ "LEFT JOIN address a ON e.emp_id=a.emp_fk_id"
			+ " WHERE a.add_state=:state", nativeQuery = true)
	public List<EmployeeDetails> getByState(String state);
}
