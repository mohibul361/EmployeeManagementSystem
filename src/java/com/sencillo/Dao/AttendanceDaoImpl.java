package com.sencillo.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Attendance;

@Repository
public class AttendanceDaoImpl implements AttendanceDao
{
        private static final Logger logger = LoggerFactory.getLogger(AttendanceDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
        public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        @Override
	public void addAttendance(Attendance a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
		logger.info("Attendance saved successfully, Attendance Details="+a);
	}
        @Override
	public void updateAttendance(Attendance a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(a);
		logger.info("Attendance updated successfully, Attendance Details="+a);
	}
        @SuppressWarnings("unchecked")
	@Override
	public List<Attendance> listAttendance() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Attendance> attendanceList = session.createQuery("from Attendance").list();
		return attendanceList;
	}
        
	@Override
	public Attendance getAttendanceById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		Attendance a = (Attendance) session.load(Attendance.class, new Integer(id));
		logger.info("Attendance loaded successfully, Attendance details="+a);
		return a;
	}
        @Override
	public void deleteAttendance(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Attendance a = (Attendance) session.load(Attendance.class, new Integer(id));
		if(null != a){
			session.delete(a);
		}
		logger.info("Attendance deleted successfully, Attendance details="+a);
	}
	

}


