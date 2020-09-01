package io.cgg.springbootsecurity.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.cgg.springbootsecurity.model.Employee;
import io.cgg.springbootsecurity.model.User;
import io.cgg.springbootsecurity.springbootservice.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/viewEmployees")
    public ModelAndView getEmployeeList() {
		System.out.println(" inside getEmployeeList calling >>>>>>>>>>>>>>>>>>>>>>>>>>");
		ModelAndView empview = new ModelAndView("viewEmployees");
		List<Employee> empList = employeeService.getEmployeeList();
		empview.addObject("empList", empList);
		return empview;
		
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("addEmployee");
		Employee employeeObj = employeeService.getEmployeeById(id);
		if (employeeObj == null) {
			throw new RuntimeException("Employee not found" + id);
		}
		mav.addObject("employee", employeeObj);
		return mav;
	}
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public String adduser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
			      return "user"; // jsp of the given file.
			  }
			 System.out.println(user.toString());
			employeeService.saveUser(user);
			return "redirect:/";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("employee") Employee employeeObj, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
		      return "addEmployee";
		  }
		 System.out.println(employeeObj.toString());
		employeeService.saveEmployee(employeeObj);
		return "redirect:viewEmployees";
	}
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployee() {
		ModelAndView empview = new ModelAndView("addEmployee");
		empview.addObject("employee", new Employee());
		return empview;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delEmployeeById(@PathVariable("id") int id) {
		employeeService.delEmployeeById(id);
		ModelAndView empview = new ModelAndView("viewEmployees");
		List<Employee> empList = employeeService.getEmployeeList();
		empview.addObject("empList", empList);
		return empview;
	}
	
}
