package com.sencillo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sencillo.dao.LeaveTypeDao;
import com.sencillo.model.LeaveType;

@Service
@Transactional
public class LeaveTypeServiceImpl implements LeaveTypeService {

	@Autowired
	private LeaveTypeDao leaveTypeDao;

         public void setLeaveTypeDao(LeaveTypeDao leaveTypeDao) {
		this.leaveTypeDao = leaveTypeDao;
	}
        
        @Override
	@Transactional
	public void updateLeaveType(LeaveType l) {
		this.leaveTypeDao.updateLeaveType(l);
	}
        
        @Override
	@Transactional
	public List<LeaveType> listLeaveType() {
		return this.leaveTypeDao.listLeaveType();
	}

        @Override
        @Transactional
        public List<LeaveType> listEmployeeLeaveType() {
                return this.leaveTypeDao.listEmployeeLeaveType();
        }
        
        @Override
	@Transactional
	public void addLeaveType(LeaveType l) {
		this.leaveTypeDao.addLeaveType(l);
	}
        
	@Override
	@Transactional
	public LeaveType getLeaveTypeById(int id) {
		return this.leaveTypeDao.getLeaveTypeById(id);
        }
        
        @Override
	@Transactional
	public void deleteLeaveType(int id) {
		this.leaveTypeDao.deleteLeaveType(id);
	}
        

}