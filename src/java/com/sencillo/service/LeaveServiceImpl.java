package com.sencillo.service;

import com.sencillo.dao.LeaveDao;
import com.sencillo.model.Leave;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveDao leaveDao;

    public void setLeaveDao(LeaveDao leaveDao) {
        this.leaveDao = leaveDao;
    }

    @Override
    @Transactional
    public void updateLeave(Leave l) {
        this.leaveDao.updateLeave(l);
    }

    @Override
    @Transactional
    public List<Leave> listLeave() {
        return this.leaveDao.listLeave();
    }
    
    @Override
    @Transactional
    public List<Leave> listEmployeeLeaveProfile(Integer employeeId) {
	return this.leaveDao.listEmployeeLeaveProfile(employeeId);
    }
    
    @Override
    @Transactional
    public List<Leave> listLeaveReport(Date fromDate, Date toDate) {
        return this.leaveDao.listLeaveReport(fromDate, toDate);
    }

    @Override
    @Transactional
    public List<Leave> listPendingLeave() {
        return this.leaveDao.listPendingLeave();
    }

    @Override
    @Transactional
    public void addLeave(Leave l) {
        this.leaveDao.addLeave(l);
    }

    @Override
    public void updateStatus(String status, Integer leaveId)  {
        this.leaveDao.updateStatus(status, leaveId);

    }

    @Override
    @Transactional
    public Leave getLeaveById(int id) {
        return this.leaveDao.getLeaveById(id);
    }

    @Override
    @Transactional
    public void deleteLeave(int id) {
        this.leaveDao.deleteLeave(id);
    }

}
