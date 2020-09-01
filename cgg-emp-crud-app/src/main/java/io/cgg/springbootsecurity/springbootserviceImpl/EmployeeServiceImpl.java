package io.cgg.springbootsecurity.springbootserviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.cgg.springbootsecurity.model.Employee;
import io.cgg.springbootsecurity.model.User;
import io.cgg.springbootsecurity.springbootdao.EmployeeDao;
import io.cgg.springbootsecurity.springbootservice.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired 
	EmployeeDao empDao;
	
	@Override
	public List<Employee> getEmployeeList() {
		
		return empDao.getEmployeeList();
	}

	@Override
	public String delEmployeeById(int id) {
		// TODO Auto-generated method stub
		return empDao.delEmployeeById(id);
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return empDao.saveEmployee(emp);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return empDao.getEmployeeById(id);
	}

	@Override
	public User saveUser(User user) {
		return empDao.saveUser(user);
	}

}
