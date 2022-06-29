package com.sencillo.dao;

import java.util.List;
import com.sencillo.model.Payroll;

public interface PayrollDao
{
	public void addPayroll(Payroll p);
        public void updatePayroll(Payroll p);
        public List<Payroll> listPayroll();
        public List<Payroll> listEmployeePayrollProfile(Integer employeeId);
        public Payroll getPayrollById(int id);
        public void deletePayroll(int id);
}

