package com.employeereport.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@NamedQuery(
		name="showbyphone",
		query = "FROM EmployeeDetails e WHERE e.phone=?1"
		)
@Entity
@Table(name="employee_details")
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer id;
	@Column(name="emp_name")
	private String name;
	@Column(name="emp_email")
	private String email;
	@Column(name="emp_phone")
	private Long phone;
	@Column(name="emp_location")
	private String location;
	@OneToMany(targetEntity = AddressDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name="emp_fk_id", referencedColumnName = "emp_id")
	private List <AddressDetails> address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<AddressDetails> getAddress() {
		return address;
	}
	public void setAddress(List<AddressDetails> address) {
		this.address = address;
	}
	

}
