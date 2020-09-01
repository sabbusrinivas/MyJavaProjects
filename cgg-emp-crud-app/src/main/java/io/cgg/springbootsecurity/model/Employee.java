package io.cgg.springbootsecurity.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="employee")
public class Employee{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column
	private int id;
	
	@Size(min = 3, max = 255, message = "Please enter between {min} and {max} characters.")
	@Column
	private String name;
	
	@NotEmpty(message="Email is required")
	@Email(message="Email is invalid")
	@Column
	private String email;
	
	@NotNull(message="Date of birth required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private Date dob;
	
	@Min(value = 10_000, message="must be equal or greater than 10,000}")
	@Max(value = 200_000, message="must be equal or less than 200,000")
	@Column
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", salary=" + salary
				+ "]";
	}

	
}
