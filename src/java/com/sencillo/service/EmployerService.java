package com.sencillo.service;

import com.sencillo.model.Employee;
import java.util.List;

public interface EmployerService
{
	public void addEmployee(Employee e);
        public void updateEmployee(Employee e);
        public List<Employee> listEmployee();
        public Employee getEmployeeById(int id);
        public void deleteEmployee(int id);
        public Employee getEmployee(String email);
}