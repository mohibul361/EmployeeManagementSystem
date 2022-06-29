package com.sencillo.service;

import com.sencillo.model.Department;
import java.util.List;

public interface DepartmentService
{
	public void addDepartment(Department d);
        public void updateDepartment(Department d);
        public List<Department> listDepartment();
        public Department getDepartmentById(int id);
        public Department getDepartment(String departmentEmail);
        public void deleteDepartment(int id);
}

