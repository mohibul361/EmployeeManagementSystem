package com.sencillo.service;

import com.sencillo.model.Payroll;
import java.util.List;

public interface PayrollService
{
	public void addPayroll(Payroll p);
        public void updatePayroll(Payroll p);
        public List<Payroll> listPayroll();
        public List<Payroll> listEmployeePayrollProfile(Integer employeeId);
        public Payroll getPayrollById(int id);
        public void deletePayroll(int id);
}
