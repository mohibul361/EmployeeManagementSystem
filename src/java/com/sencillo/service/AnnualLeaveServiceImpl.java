package com.sencillo.service;

import com.sencillo.dao.AnnualLeaveDao;
import com.sencillo.model.AnnualLeave;
import com.sencillo.model.Leave;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AnnualLeaveServiceImpl implements AnnualLeaveService
{     

	@Autowired
	private  AnnualLeaveDao annualLeaveDao;
	
        public void setAnnualLeaveDao(AnnualLeaveDao annualLeaveDao) {
		this.annualLeaveDao = annualLeaveDao;
	}
        
        @Override
	@Transactional
	public void updateAnnualLeave(AnnualLeave a) {
		this.annualLeaveDao.updateAnnualLeave(a);
	}
        
        @Override
	@Transactional
	public List<AnnualLeave> listAnnualLeave() {
		return this.annualLeaveDao.listAnnualLeave();
	}
        
        @Override
        @Transactional
        public List<AnnualLeave> listEmployeeAnnualLeaveProfile(Integer employeeId) {
            return this.annualLeaveDao.listEmployeeAnnualLeaveProfile(employeeId);
        }
        
        @Override
	@Transactional
	public void addAnnualLeave(AnnualLeave a) {
		this.annualLeaveDao.addAnnualLeave(a);
	}
        
	@Override
	@Transactional
	public AnnualLeave getAnnualLeaveById(int id) {
		return this.annualLeaveDao.getAnnualLeaveById(id);
        }
        
        @Override
	@Transactional
	public void deleteAnnualLeave(int id) {
		this.annualLeaveDao.deleteAnnualLeave(id);
	}
        
        @Override
	@Transactional
        public void updateAnnualLeaveAfterLeaveApproval(Leave l){
                this.annualLeaveDao.updateAnnualLeaveAfterLeaveApproval(l);
        }
        @Override
        public int getLeaveTypeBalanceByEmployee(Integer leaveTypeId, Integer employeeId)
        {
            return this.annualLeaveDao.getLeaveTypeBalanceByEmployee(leaveTypeId, employeeId);
        }
        
	
}

 
