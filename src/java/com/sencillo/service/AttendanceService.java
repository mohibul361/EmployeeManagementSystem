package com.sencillo.service;

import com.sencillo.model.Attendance;
import java.util.List;

public interface AttendanceService
{
	public void addAttendance(Attendance a);
        public void updateAttendance(Attendance a);
        public List<Attendance> listAttendance();
        public Attendance getAttendanceById(int id);
        public void deleteAttendance(int id);
}

