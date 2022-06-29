package com.sencillo.service;

import com.sencillo.model.Salary;
import java.util.List;

public interface SalaryService
{
	public void addSalary(Salary s);
        public void updateSalary(Salary s);
        public List<Salary> listSalary();
        public Salary getSalaryById(int id);
        public void deleteSalary(int id);
}
