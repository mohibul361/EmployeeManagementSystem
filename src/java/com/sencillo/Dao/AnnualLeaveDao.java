package com.sencillo.dao;

import java.util.List;
import com.sencillo.model.AnnualLeave;
import com.sencillo.model.Leave;

public interface AnnualLeaveDao
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
