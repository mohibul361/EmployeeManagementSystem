package com.sencillo.service;

import com.sencillo.dao.SalaryDao;
import com.sencillo.model.Salary;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SalaryServiceImpl implements SalaryService
{     

	@Autowired
	private  SalaryDao salaryDao;
	
        public void setSalaryDao(SalaryDao salaryDao) {
		this.salaryDao = salaryDao;
	}
        
        @Override
	@Transactional
	public void updateSalary(Salary s) {
		this.salaryDao.updateSalary(s);
	}
        
        @Override
	@Transactional
	public List<Salary> listSalary() {
		return this.salaryDao.listSalary();
	}

        
        @Override
	@Transactional
	public void addSalary(Salary s) {
		this.salaryDao.addSalary(s);
	}
        
	@Override
	@Transactional
	public Salary getSalaryById(int id) {
		return this.salaryDao.getSalaryById(id);
        }
        
        @Override
	@Transactional
	public void deleteSalary(int id) {
		this.salaryDao.deleteSalary(id);
	}
        
	
}

 
