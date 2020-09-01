package io.cgg.springbootsecurity.springbootdaoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.cgg.springbootsecurity.model.Employee;
import io.cgg.springbootsecurity.model.User;
import io.cgg.springbootsecurity.springbootdao.EmployeeDao;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {


	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getEmployeeList() {
	
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> empList = query.getResultList();
		if(empList != null) {
		System.out.println(" empList size is  ************ "+empList.size());
		}else {
			System.out.println(" empList is null >>>>>>>>>>>>");
		}
		return empList;
	}

	@Override
	public String delEmployeeById(int id) {
		try {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		currentSession.delete(employeeObj);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return "success";
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		try{
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
		return emp;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Employee getEmployeeById(int id) {
		try {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		return employeeObj;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User saveUser(User user) {
		try{
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.saveOrUpdate(user);
			return user;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}

}
