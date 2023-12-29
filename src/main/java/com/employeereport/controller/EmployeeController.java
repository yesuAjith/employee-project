package com.employeereport.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeereport.entity.EmployeeDetails;
import com.employeereport.entity.UserInfo;
import com.employeereport.service.EmployeeService;

@RestController

@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService empServ;
	@PostMapping("/send")
	public List <EmployeeDetails> sendData(@RequestBody List<EmployeeDetails> emp){
		return empServ.sendAll(emp);
		
	}
	
	@GetMapping("/getAll")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<EmployeeDetails> getData(EmployeeDetails emp){
		return empServ.getAllInfo(emp);
	}
	
	@GetMapping("/getById/{id}")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public Optional<EmployeeDetails> getById(@PathVariable("id") Integer id) {
		return empServ.getInfoWithId(id);
		
	}
	
	@PutMapping("/update/{id}")
	public EmployeeDetails updateEmp(@PathVariable("id") Integer id, @RequestBody EmployeeDetails emp) {
		return empServ.updateEmployee(id, emp);
	}
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteEmployee(@PathVariable("id")Integer id) {
		empServ.DeleteEmployee(id);
		return "Employee Deleted";
	}
	@GetMapping("getName/{name}")
	public List<EmployeeDetails> getName(@PathVariable("name")String na){
		return empServ.GetByName(na);
	}
	@GetMapping("getLocation/{location}")
	public List<EmployeeDetails>getLoca(@PathVariable("location") String location){
		return empServ.getByLoc(location);
	}
	
	@GetMapping("getPhone/{phone}")
	public EmployeeDetails getPhone(@PathVariable("phone") Long ph) {
		return empServ.getByPhone(ph);
		
	}
	
	@GetMapping("getState/{state}")
	public List<EmployeeDetails>getState(@PathVariable("state") String st){
		return empServ.getBystate(st);
	}
	
	@PostMapping("/adduser")
	public UserInfo useradd(@RequestBody UserInfo user) {
		return empServ.userAddInfo(user);
	}

}
