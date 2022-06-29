package com.sencillo.dao;

import java.util.List;
import com.sencillo.model.Attendance;

public interface AttendanceDao
{
	public void addAttendance(Attendance a);
        public void updateAttendance(Attendance a);
        public List<Attendance> listAttendance();
        public Attendance getAttendanceById(int id);
        public void deleteAttendance(int id);
}
