package io.cgg.springbootsecurity.springbootservice;

import io.cgg.springbootsecurity.model.User;
import io.cgg.springbootsecurity.springbootDto.MyLoginFormsDTO;

public interface UserLoginSessionService {

	User loginCredentials(MyLoginFormsDTO myLoginFormsDTO);
	
}
