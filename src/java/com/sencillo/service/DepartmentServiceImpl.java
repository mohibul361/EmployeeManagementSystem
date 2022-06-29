package com.sencillo.service;

import com.sencillo.dao.DepartmentDao;
import com.sencillo.model.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService
{     

	@Autowired
	private  DepartmentDao departmentDao;
	
        public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
        
        @Override
	@Transactional
	public void updateDepartment(Department d) {
		this.departmentDao.updateDepartment(d);
	}
        
        @Override
	@Transactional
	public List<Department> listDepartment() {
		return this.departmentDao.listDepartment();
	}

        
        @Override
	@Transactional
	public void addDepartment(Department d) {
		this.departmentDao.addDepartment(d);
	}
        
	@Override
	@Transactional
	public Department getDepartmentById(int id) {
		return this.departmentDao.getDepartmentById(id);
        }
        
        @Override
	@Transactional
	public Department getDepartment(String departmentEmail) {
		return this.departmentDao.getDepartment(departmentEmail);
        }
        
        @Override
	@Transactional
	public void deleteDepartment(int id) {
		this.departmentDao.deleteDepartment(id);
	}
        
	
}

 
