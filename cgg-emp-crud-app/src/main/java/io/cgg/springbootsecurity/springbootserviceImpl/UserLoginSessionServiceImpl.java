package io.cgg.springbootsecurity.springbootserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.cgg.springbootsecurity.model.User;
import io.cgg.springbootsecurity.springbootDto.MyLoginFormsDTO;
import io.cgg.springbootsecurity.springbootdao.UserDAO;
import io.cgg.springbootsecurity.springbootservice.UserLoginSessionService;

@Service
public class UserLoginSessionServiceImpl implements UserLoginSessionService {

	 @Autowired 
	 UserDAO userDao;
	
	@Override
	public User loginCredentials(MyLoginFormsDTO myLoginFormsDTO) {
		//UserDAOImpl userDao = new UserDAOImpl();
		System.out.println(" inside DAO Callling >>>>>>>>>>>>>>>>>>>>>");
		return userDao.loginCredentials(myLoginFormsDTO);
	}

	

}
