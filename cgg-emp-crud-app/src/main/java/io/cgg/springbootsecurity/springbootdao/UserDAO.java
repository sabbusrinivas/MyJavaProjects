package io.cgg.springbootsecurity.springbootdao;

import io.cgg.springbootsecurity.model.User;
import io.cgg.springbootsecurity.springbootDto.MyLoginFormsDTO;

public interface UserDAO {
	
	
    User loginCredentials(MyLoginFormsDTO myLoginFormsDTO);
	
}
