package com.sencillo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.AnnualLeave;
import com.sencillo.model.Leave;

@Repository
public class AnnualLeaveDaoImpl implements AnnualLeaveDao {

    private static final Logger logger = LoggerFactory.getLogger(AnnualLeaveDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addAnnualLeave(AnnualLeave a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
        logger.info("AnnualLeave saved successfully, AnnualLeave Details=" + a);
    }

    @Override
    public void updateAnnualLeave(AnnualLeave a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
        logger.info("AnnualLeave updated successfully, AnnualLeave Details=" + a);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AnnualLeave> listAnnualLeave() {
        Session session = this.sessionFactory.getCurrentSession();
        List<AnnualLeave> annualLeaveList = session.createQuery("from AnnualLeave").list();
        return annualLeaveList;
    }

    @Override
    public AnnualLeave getAnnualLeaveById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AnnualLeave a = (AnnualLeave) session.load(AnnualLeave.class, new Integer(id));
        logger.info("AnnualLeave loaded successfully, AnnualLeave details=" + a);
        return a;
    }

    @Override
    public void deleteAnnualLeave(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AnnualLeave a = (AnnualLeave) session.load(AnnualLeave.class, new Integer(id));
        if (null != a) {
            session.delete(a);
        }
        logger.info("AnnualLeave deleted successfully, AnnualLeave details=" + a);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AnnualLeave> listEmployeeAnnualLeaveProfile(Integer employeeId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<AnnualLeave> employeeAnnualLeaveProfile = (List<AnnualLeave>) session.createQuery("SELECT o from AnnualLeave o WHERE o.employee.id=:employeeId").setParameter("employeeId", employeeId).list();
        return employeeAnnualLeaveProfile;
    }

    @Override
    public void updateAnnualLeaveAfterLeaveApproval(Leave leave) {
        try {

            Session session = this.sessionFactory.getCurrentSession();
            Leave l = (Leave) session.load(Leave.class, leave.getId());
            int daysTaken = Integer.parseInt(l.getTotalDay());
            System.out.println("daysTaken = " + daysTaken);
            //get annual leave entry for employee and leave type;
            AnnualLeave annualLeave = (AnnualLeave) session.createQuery("from AnnualLeave o where o.leaveType.id=:leaveTypeId and o.employee.id=:employeeId")
                    .setParameter("leaveTypeId", l.getLeaveType().getId())
                    .setParameter("employeeId", l.getEmployee().getId()).uniqueResult();

            int prevCummulativeLeave = annualLeave.getCummulativeDaysTaken();
            System.out.println("prevCummulativeLeave = " + prevCummulativeLeave);
            //calculate new cummulative and remaining leave
            int newCummulativeLeave = prevCummulativeLeave + daysTaken;
            int remainingLeave = annualLeave.getLeaveDaysAllowed() - newCummulativeLeave;
            // update Annual Leave info for that employee and leave type
            annualLeave.setCummulativeDaysTaken(newCummulativeLeave);
            annualLeave.setRemainingDays(remainingLeave);
            session.update(annualLeave);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLeaveTypeBalanceByEmployee(Integer leaveTypeId, Integer employeeId) {
        try {
            System.out.println("employeeId = " + employeeId);
            Session session = this.sessionFactory.getCurrentSession();
            AnnualLeave annualLeave = (AnnualLeave) session.createQuery("from AnnualLeave o where o.leaveType.id=:leaveTypeId and o.employee.id=:employeeId")
                    .setParameter("leaveTypeId", leaveTypeId).setParameter("employeeId", employeeId).uniqueResult();
            
            System.out.println("annualLeave = " + annualLeave);
            if (annualLeave != null) {
                return annualLeave.getRemainingDays();
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
