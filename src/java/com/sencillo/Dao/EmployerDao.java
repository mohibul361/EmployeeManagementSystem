package com.sencillo.dao;

import java.util.List;
import com.sencillo.model.Employee;

public interface EmployerDao
{
	public void addEmployee(Employee e);
        public void updateEmployee(Employee e);
        public List<Employee> listEmployee();
        public Employee getEmployeeById(int id);
        public void deleteEmployee(int id);
        public Employee getEmployee(String emnail);
}