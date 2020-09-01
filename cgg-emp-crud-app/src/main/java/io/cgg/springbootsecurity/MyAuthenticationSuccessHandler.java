package io.cgg.springbootsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.cgg.springbootsecurity.model.User;

@Configuration
@EnableTransactionManagement
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	System.out.println("seesion"+request.getSession().getId());
	HttpSession session =	request.getSession(false);
	System.out.println("user principal is "+authentication.getPrincipal());
	User user = (User)authentication.getPrincipal();
	System.out.println("user name is "+user.getName());
	System.out.println("authentication.getName() is "+authentication.getName());
	System.out.println("user authorities is "+authentication.getAuthorities());
	response.sendRedirect("/viewEmployees");
	}

	 
}
