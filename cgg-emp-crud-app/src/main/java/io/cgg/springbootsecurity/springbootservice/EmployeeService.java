package io.cgg.springbootsecurity.springbootservice;

import java.util.List;

import io.cgg.springbootsecurity.model.Employee;
import io.cgg.springbootsecurity.model.User;


public interface EmployeeService {
	
	List<Employee> getEmployeeList();
	String delEmployeeById(int id);
	Employee saveEmployee(Employee emp);
	User saveUser(User user);
	Employee getEmployeeById(int id);

}
