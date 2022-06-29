package com.sencillo.service;

import com.sencillo.model.AnnualLeave;
import com.sencillo.model.Leave;
import java.util.List;

public interface AnnualLeaveService
{
	public void addAnnualLeave(AnnualLeave a);
        public void updateAnnualLeave(AnnualLeave a);
        public List<AnnualLeave> listAnnualLeave();
        public List<AnnualLeave> listEmployeeAnnualLeaveProfile(Integer employeeId);
        public void updateAnnualLeaveAfterLeaveApproval(Leave l);
        public AnnualLeave getAnnualLeaveById(int id);
        public void deleteAnnualLeave(int id);
        public int getLeaveTypeBalanceByEmployee(Integer leaveTypeId, Integer employeeId);
}

