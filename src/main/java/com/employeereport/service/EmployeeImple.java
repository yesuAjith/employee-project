package com.employeereport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employeereport.entity.EmployeeDetails;
import com.employeereport.entity.UserInfo;
import com.employeereport.repository.EmployeeRepository;
import com.employeereport.repository.UserInfoRepository;

@Service
public class EmployeeImple implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private UserInfoRepository userinfo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<EmployeeDetails> sendAll(List<EmployeeDetails> emp) {
		
		return empRepo.saveAll(emp);
	}



	@Override
	public List<EmployeeDetails> getAllInfo(EmployeeDetails emp) {
		
		return empRepo.findAll();
	}



	@Override
	public Optional<EmployeeDetails> getInfoWithId(Integer id) {
		
		return empRepo.findById(id);
	}



	@Override
	public EmployeeDetails updateEmployee(Integer id, EmployeeDetails emp) {
		Optional<EmployeeDetails> employee = empRepo.findById(id);
		EmployeeDetails employeeUpdate=employee.get();
		employeeUpdate.setName(emp.getName());
		employeeUpdate.setPhone(emp.getPhone());
		employeeUpdate.setEmail(emp.getEmail());
		employeeUpdate.setLocation(emp.getLocation());
		employeeUpdate.setAddress(emp.getAddress());
		return empRepo.save(employeeUpdate);
	}



	@Override
	public String DeleteEmployee(Integer id) {
		empRepo.deleteById(id);
		return "Request Deleted";
	}



	@Override
	public List<EmployeeDetails> GetByName(String name) {
		
		return empRepo.getByName(name);
	}



	@Override
	public List<EmployeeDetails> getByLoc(String loc) {
		
		return empRepo.getByLocation(loc);
	}



	@Override
	public EmployeeDetails getByPhone(Long phone) {
		
		return empRepo.getByPhoneNumber(phone);
	}



	@Override
	public List<EmployeeDetails> getBystate(String state) {
		return empRepo.getByState(state);
	}



	@Override
	public UserInfo userAddInfo(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		return userinfo.save(userInfo);
	}
	
}
