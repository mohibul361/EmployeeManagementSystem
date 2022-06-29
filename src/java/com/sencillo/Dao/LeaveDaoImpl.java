package com.sencillo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Leave;
import java.util.Date;

@Repository
public class LeaveDaoImpl implements LeaveDao {

    private static final Logger logger = LoggerFactory.getLogger(LeaveDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addLeave(Leave l) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.persist(l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Leave saved successfully, Leave Details=" + l);
    }

    @Override
    public void updateLeave(Leave l) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(l);
        logger.info("Leave updated successfully, Leave Details=" + l);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Leave> listLeave() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Leave> leaveList = session.createQuery("from Leave").list();
        return leaveList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Leave> listPendingLeave() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Leave> pendingLeaveList = session.createQuery("SELECT o from Leave o WHERE o.status='pending'").list();
        return pendingLeaveList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Leave> listEmployeeLeaveProfile(Integer employeeId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Leave> employeeLeaveProfile = (List<Leave>) session.createQuery("SELECT o from Leave o WHERE o.employee.id=:employeeId").setParameter("employeeId", employeeId).list();
        return employeeLeaveProfile;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Leave> listLeaveReport(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Leave> leaveReport = session.createQuery("from Leave where dateOfApplication between :fromDate and :toDate ").setParameter("fromDate", fromDate).setParameter("toDate", toDate).list();
        return leaveReport;
    }

    @Override
    public Leave getLeaveById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Leave l = (Leave) session.load(Leave.class, new Integer(id));
        logger.info("Leave loaded successfully, Leave details=" + l);
        return l;
    }

    @Override
    public void deleteLeave(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Leave l = (Leave) session.load(Leave.class, new Integer(id));
        if (null != l) {
            session.delete(l);
        }
        logger.info("Leave deleted successfully, Leave details=" + l);
    }

    @Override
    public void updateStatus(String status, Integer leaveId) {
        Session session = this.sessionFactory.getCurrentSession();
        Leave l = (Leave) session.load(Leave.class, new Integer(leaveId));
        l.setStatus(status);
        session.update(l);

    }

}
