package io.cgg.springbootsecurity;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.cgg.springbootsecurity.model.Employee;
import io.cgg.springbootsecurity.model.User;

@RestController
public class HomeResource {


	 @GetMapping("/")
	 public ModelAndView getLogin() {
		 ModelAndView mav = new ModelAndView("home");
		  return mav;
	 }
    @GetMapping("/register")
    public ModelAndView user() {
    	ModelAndView mav = new ModelAndView("user");
    	mav.addObject("user", new User());
    	return mav;
    }
  
    
    @RequestMapping("/403")
	public ModelAndView accessDenidePage() {
		ModelAndView mav = new ModelAndView("persmissionDenied");
		return mav;
	}
    /*
	 * @RequestMapping(value = {"/login"}) public ModelAndView getLogin() {
	 * ModelAndView mav = new ModelAndView("login");
	 * 
	 * return mav; }
	 */
}
