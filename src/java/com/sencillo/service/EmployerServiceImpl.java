package com.sencillo.service;

import com.sencillo.dao.EmployerDao;
import com.sencillo.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmployerServiceImpl implements EmployerService
{     

	@Autowired
	private  EmployerDao employerDao;
	
        public void setEmployerDao(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
        
        @Override
	@Transactional
	public void updateEmployee(Employee e) {
		this.employerDao.updateEmployee(e);
	}
        
        @Override
	@Transactional
	public List<Employee> listEmployee() {
		return this.employerDao.listEmployee();
	}

        
        @Override
	@Transactional
	public void addEmployee(Employee e) {
		this.employerDao.addEmployee(e);
	}
        
	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return this.employerDao.getEmployeeById(id);
                
        }
        
        @Override
	@Transactional
	public void deleteEmployee(int id) {
		this.employerDao.deleteEmployee(id);
	}
        
        @Override
	@Transactional
	public Employee getEmployee(String email) {
		return this.employerDao.getEmployee(email);
                
        }
        

        
	
}

 