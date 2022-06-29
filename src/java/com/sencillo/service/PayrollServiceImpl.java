package com.sencillo.service;

import com.sencillo.dao.PayrollDao;
import com.sencillo.model.Payroll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PayrollServiceImpl implements PayrollService
{     

	@Autowired
	private  PayrollDao payrollDao;
	
        public void setPayrollDao(PayrollDao payrollDao) {
		this.payrollDao = payrollDao;
	}
        
        @Override
	@Transactional
	public void updatePayroll(Payroll p) {
		this.payrollDao.updatePayroll(p);
	}
        
        @Override
	@Transactional
	public List<Payroll> listPayroll() {
		return this.payrollDao.listPayroll();
	}
        
        @Override
	@Transactional
	public List<Payroll> listEmployeePayrollProfile(Integer employeeId) {
		return this.payrollDao.listEmployeePayrollProfile(employeeId);
	}
        
        @Override
	@Transactional
	public void addPayroll(Payroll p) {
		this.payrollDao.addPayroll(p);
	}
        
	@Override
	@Transactional
	public Payroll getPayrollById(int id) {
		return this.payrollDao.getPayrollById(id);
        }
        
        @Override
	@Transactional
	public void deletePayroll(int id) {
		this.payrollDao.deletePayroll(id);
	}
        
	
}

 
