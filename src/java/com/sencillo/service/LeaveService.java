package com.sencillo.service;

import com.sencillo.model.Leave;
import java.util.Date;
import java.util.List;

public interface LeaveService {

    public void addLeave(Leave l);
    public void updateLeave(Leave l);
    public List<Leave> listLeave();
    public List<Leave> listPendingLeave();
    public List<Leave> listEmployeeLeaveProfile(Integer employeeId);
    public List<Leave> listLeaveReport(Date fromDate, Date toDate);
    public Leave getLeaveById(int id);
    public void deleteLeave(int id);
    public void updateStatus(String status, Integer leaveId);

}
