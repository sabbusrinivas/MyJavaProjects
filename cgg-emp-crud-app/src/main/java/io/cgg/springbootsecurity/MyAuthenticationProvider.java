package io.cgg.springbootsecurity;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import io.cgg.springbootsecurity.model.User;
import io.cgg.springbootsecurity.springbootDto.MyLoginFormsDTO;
import io.cgg.springbootsecurity.springbootservice.UserLoginSessionService;


@Component
public class MyAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	UserLoginSessionService loginSessionService;
	
	@Override
    public Authentication authenticate(Authentication authentication)
      throws AuthenticationException {
  
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
      MyLoginFormsDTO toysLoginFormsDTO = new MyLoginFormsDTO ();
      toysLoginFormsDTO.setEmail(email);
      toysLoginFormsDTO.setPassword(password);
      User user = loginSessionService.loginCredentials(toysLoginFormsDTO);
        if(null != user) {
        	return new UsernamePasswordAuthenticationToken(user, password,new ArrayList<>());
        	
        }else {
                throw new BadCredentialsException("Bad Credentials");
            }
        }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    

}
