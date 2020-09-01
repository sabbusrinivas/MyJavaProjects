package io.cgg.springbootsecurity.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Size(min = 3, max = 255, message = "Please enter between {min} and {max} characters.")
	@Column
	private String name;
	
	@NotEmpty(message="Gender is required")
	@Column
	private String gender;
	
	@NotEmpty(message="Department is required")
	@Column
	private String department;
	
	@NotNull(message="Date of birth required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private Date dob;
	
	@NotEmpty(message="Email is required")
	@Email(message="Email is invalid")
	@Column
	private String email;
	
	@Size(min = 4, max = 15, message = "Please enter between {min} and {max} characters.")
	@Column
	private String password;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department + ", dob="
				+ dob + ",email= " +email+", password=" +password+"]";
	}
	
}
