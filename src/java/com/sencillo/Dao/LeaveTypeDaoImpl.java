package com.sencillo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.LeaveType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class LeaveTypeDaoImpl implements LeaveTypeDao
{

	private static final Logger logger = LoggerFactory.getLogger(LeaveTypeDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

        @Override
	public void addLeaveType(LeaveType l) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(l);
		logger.info("LeaveType saved successfully, Holiday Details="+l);
	}
        @Override
	public void updateLeaveType(LeaveType l) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(l);
		logger.info("LeaveType updated successfully, LeaveType Details="+l);
	}
        
        @SuppressWarnings("unchecked")
	@Override
	public List<LeaveType> listLeaveType() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LeaveType> leaveTypeList = session.createQuery("from LeaveType").list();
		return leaveTypeList;
	}
        
        @SuppressWarnings("unchecked")
        @Override
        public List<LeaveType> listEmployeeLeaveType() {
                Session session = this.sessionFactory.getCurrentSession();
                List<LeaveType> employeeLeaveTypeList = session.createQuery("from LeaveType").list();
                return employeeLeaveTypeList;
        }
        
	@Override
	public LeaveType getLeaveTypeById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		LeaveType l = (LeaveType) session.load(LeaveType.class, new Integer(id));
		logger.info("LeaveType loaded successfully, LeaveType details="+l);
		return l;
	}
        @Override
	public void deleteLeaveType(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		LeaveType l = (LeaveType) session.load(LeaveType.class, new Integer(id));
		if(null != l){
			session.delete(l);
		}
		logger.info("LeaveType deleted successfully, LeaveType details="+l);
	}

}