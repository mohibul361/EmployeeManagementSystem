package com.sencillo.dao;

import java.util.List;

import com.sencillo.model.LeaveType;

public interface LeaveTypeDao
{
	public void addLeaveType(LeaveType l);
        public void updateLeaveType(LeaveType l);
        public List<LeaveType> listLeaveType();
        public List<LeaveType> listEmployeeLeaveType();
        public LeaveType getLeaveTypeById(int id);
        public void deleteLeaveType(int id);
}
