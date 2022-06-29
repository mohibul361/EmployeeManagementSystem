package com.sencillo.dao;

import java.util.List;
import com.sencillo.model.Salary;

public interface SalaryDao
{
	public void addSalary(Salary s);
        public void updateSalary(Salary s);
        public List<Salary> listSalary();
        public Salary getSalaryById(int id);
        public void deleteSalary(int id);
}
