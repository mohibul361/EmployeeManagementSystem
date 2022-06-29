package com.sencillo.dao;

import java.util.List;
import com.sencillo.model.Department;

public interface DepartmentDao
{
	public void addDepartment(Department d);
        public void updateDepartment(Department d);
        public List<Department> listDepartment();
        public Department getDepartmentById(int id);
        public Department getDepartment(String departmentEmail);
        public void deleteDepartment(int id);
}
