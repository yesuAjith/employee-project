package com.employeereport.service;

import java.util.List;
import java.util.Optional;

import com.employeereport.entity.EmployeeDetails;
import com.employeereport.entity.UserInfo;

public interface EmployeeService {
	
	public List<EmployeeDetails>sendAll(List<EmployeeDetails> emp);
	public List<EmployeeDetails>getAllInfo(EmployeeDetails emp);
	public Optional<EmployeeDetails> getInfoWithId(Integer id);
	public EmployeeDetails updateEmployee(Integer id, EmployeeDetails emp);
	public String DeleteEmployee (Integer id);
	public List<EmployeeDetails>GetByName(String name);
	public List<EmployeeDetails>getByLoc(String loc);
	public EmployeeDetails getByPhone(Long phone);
	public List <EmployeeDetails> getBystate(String state);
	public UserInfo userAddInfo(UserInfo userInfo);
}