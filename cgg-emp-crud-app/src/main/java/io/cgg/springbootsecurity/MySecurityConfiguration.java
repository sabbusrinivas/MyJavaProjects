package io.cgg.springbootsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MyAuthenticationProvider myAuthenticationProvider;
	
	
	  @Autowired MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	  
	//  @Autowired MyAuthenticationFailureHandler myAuthenticationFailureHandler;
	 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(myAuthenticationProvider);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
	   @Override
	   public AuthenticationManager authenticationManagerBean() throws Exception {
    	System.out.println("Authentication calling");
	       return super.authenticationManagerBean();
	   }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
    	http.headers().frameOptions().disable();
        http.authorizeRequests()
         //       .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/saveUser").permitAll()
                .antMatchers("/upload/**").permitAll()
                .antMatchers("/fileUpload").permitAll()
                .antMatchers("/slead-static/**").permitAll()
//                .antMatchers("/toysLoginForm/**").permitAll()
                .anyRequest().authenticated()
//                .antMatchers("/").permitAll()
                .and().formLogin()
      //          .failureHandler(myAuthenticationFailureHandler)
    			.successHandler(myAuthenticationSuccessHandler)
    			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
    			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout") ).deleteCookies("JSESSIONID")
    			.and().exceptionHandling().accessDeniedPage("/403");
        
//    			.defaultSuccessUrl("/toysHome");
    }
}
