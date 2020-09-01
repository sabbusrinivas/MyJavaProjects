package io.cgg.springbootsecurity.springbootdao;

import java.util.List;

import io.cgg.springbootsecurity.model.Employee;
import io.cgg.springbootsecurity.model.User;


public interface EmployeeDao {
	
	List<Employee> getEmployeeList();

	String delEmployeeById(int id);

	Employee saveEmployee(Employee emp);

	Employee getEmployeeById(int id);

	User saveUser(User user);

}
