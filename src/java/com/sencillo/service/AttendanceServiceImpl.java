package com.sencillo.service;

import com.sencillo.dao.AttendanceDao;
import com.sencillo.model.Attendance;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService
{     

	@Autowired
	private  AttendanceDao attendanceDao;
	
        public void setAtttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}
        
        @Override
	@Transactional
	public void updateAttendance(Attendance a) {
		this.attendanceDao.updateAttendance(a);
	}
        
        @Override
	@Transactional
	public List<Attendance> listAttendance() {
		return this.attendanceDao.listAttendance();
	}

        
        @Override
	@Transactional
	public void addAttendance(Attendance a) {
		this.attendanceDao.addAttendance(a);
	}
        
	@Override
	@Transactional
	public Attendance getAttendanceById(int id) {
		return this.attendanceDao.getAttendanceById(id);
        }
        
        @Override
	@Transactional
	public void deleteAttendance(int id) {
		this.attendanceDao.deleteAttendance(id);
	}
        
	
}

 
