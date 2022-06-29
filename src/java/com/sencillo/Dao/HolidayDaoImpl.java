package com.sencillo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Holiday;

@Repository
public class HolidayDaoImpl implements HolidayDao
{

        private static final Logger logger = LoggerFactory.getLogger(HolidayDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

        @Override
	public void addHoliday(Holiday h) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(h);
		logger.info("Holiday saved successfully, Holiday Details="+h);
	}
        @Override
	public void updateHoliday(Holiday h) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(h);
		logger.info("Holiday updated successfully, Holiday Details="+h);
	}
        
        @SuppressWarnings("unchecked")
	@Override
	public List<Holiday> listHoliday() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Holiday> holidayList = session.createQuery("from Holiday").list();
		return holidayList;
	}
        
        @SuppressWarnings("unchecked")
        @Override
        public List<Holiday> listEmployeeHoliday() {
                Session session = this.sessionFactory.getCurrentSession();
                List<Holiday> employeeHolidayList = session.createQuery("from Holiday").list();
                return employeeHolidayList;
        }
        
	@Override
	public Holiday getHolidayById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		Holiday h = (Holiday) session.load(Holiday.class, new Integer(id));
		logger.info("Holiday loaded successfully, Holiday details="+h);
		return h;
	}
        @Override
	public void deleteHoliday(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Holiday h = (Holiday) session.load(Holiday.class, new Integer(id));
		if(null != h){
			session.delete(h);
		}
		logger.info("Holiday deleted successfully, Holiday details="+h);
	}

}