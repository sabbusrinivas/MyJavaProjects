package io.cgg.springbootsecurity.springbootdaoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.cgg.springbootsecurity.model.User;
import io.cgg.springbootsecurity.springbootDto.MyLoginFormsDTO;
import io.cgg.springbootsecurity.springbootdao.UserDAO;


@Repository
public class UserDAOImpl implements UserDAO {

	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public User loginCredentials(MyLoginFormsDTO myLoginFormsDTO) {
		Boolean flag = false;
		Session currentSession = entityManager.unwrap(Session.class);
		
		System.out.println(myLoginFormsDTO.getEmail());
		System.out.println(myLoginFormsDTO.getPassword());
		Query<User> query = currentSession.createQuery("from User emp where emp.email =:email and emp.password =:password", User.class);
		List<User> list = query.setString("email", myLoginFormsDTO.getEmail()).setString("password", myLoginFormsDTO.getPassword()).list();
	
		System.out.println("list size is "+list.size());
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	
	}
