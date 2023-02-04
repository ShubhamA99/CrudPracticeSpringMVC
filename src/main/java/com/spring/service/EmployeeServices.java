package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

@Service
public class EmployeeServices {

	
	@Autowired
	EmployeeDao empDao;


	//add Employee
	public void addEmp(Employee emp) {
		empDao.addEmployee(emp);
	}
	
	
	// list of Emp 
	public List<Employee> getEmp(){
		return empDao.getAllEmployee();
	}
	
	
	//get emp by id
	public Employee getById(int id) {
		return empDao.GetEmpById(id);
	}
	
	
	//update Emp
	public void UpdateEmp(Employee emp) {
		empDao.UpdateEmp(emp);
	}
	
	//delete Emp
	public void DeleteEmp(int id) {
		empDao.DeleteEmp(id);
	}
}
