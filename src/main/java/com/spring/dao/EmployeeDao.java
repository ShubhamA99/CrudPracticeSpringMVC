package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spring.model.Employee;

@Component
public class EmployeeDao {

	@Autowired
	HibernateTemplate ht;
	
    // Add Employee	
	@Transactional
	public void addEmployee(Employee emp) {
		ht.save(emp);
	}
	
	
    //	Fetch all Employee
	public List<Employee> getAllEmployee(){
		return ht.loadAll(Employee.class);
	}
	
    // Get Employee By Id
	public Employee GetEmpById(int id) {
		return ht.get(Employee.class, id);
	}
	
	
	// Update Employee detail
	@Transactional
	public void UpdateEmp(Employee emp) {
		ht.update(emp);
	}
	
	
	//delete Employee 
	@Transactional
	public void DeleteEmp(int id) {
		ht.delete(ht.load(Employee.class, id));
	}   
}
