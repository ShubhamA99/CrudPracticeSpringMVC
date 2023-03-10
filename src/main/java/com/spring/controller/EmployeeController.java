package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.Employee;
import com.spring.service.EmployeeServices;




@Controller
@RequestMapping
public class EmployeeController {

	
	@Autowired
	EmployeeServices empService;
	
	//add Emp
	@GetMapping("addEmployee")
	public String addEmp() {
		return "addEmployee";
	}
	
	
	//Save Emp
	@PostMapping("insertEmployee")
	public String insertEmployee(@ModelAttribute("insertEmployee") Employee emp ) {
		
		
		empService.addEmp(emp);
		return "home";
	}
	
	
	
	//Fetch all emp Data
	@GetMapping("employeeReport")
	public String loadAllEmployee(Model m)
	{
		m.addAttribute("employee",empService.getEmp());
		m.addAttribute("title","Empolyee report");
	
		return "employeeReport";
	}
	
	
	//Edit Form 
	@GetMapping("/editEmployee/{id}")
	public String EditEmployee(@PathVariable(value="id") int id , Model m) {
		
		
		Employee emp = empService.getById(id);
		m.addAttribute("employee",emp);
		m.addAttribute("title","Edit Employee");
		
		
		return "editEmployee";
		
	}
	
	//Edit Employee
	@PostMapping("/editEmployee/updateEmployee")
	public String updateEmp(@ModelAttribute("updateEmployee") Employee emp )
	{
		empService.UpdateEmp(emp);
		return "redirect:/employeeReport";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String DeleteEmployee(@PathVariable int id)
	{
		empService.DeleteEmp(id);
		return "redirect:/employeeReport";
	}
}
