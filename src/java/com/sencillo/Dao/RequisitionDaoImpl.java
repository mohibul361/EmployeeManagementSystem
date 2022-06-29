package com.sencillo.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Requisition;

@Repository
public class RequisitionDaoImpl implements RequisitionDao
{
        private static final Logger logger = LoggerFactory.getLogger(RequisitionDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
        public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        
        @Override
	public void addRequisition(Requisition r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(r);
		logger.info("Requisition saved successfully, Requisition Details="+r);
	}
        
        @Override
	public void updateRequisition(Requisition r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(r);
		logger.info("Requisition updated successfully, Requisition Details="+r);
	}
        
        @SuppressWarnings("unchecked")
        @Override
        public List<Requisition> listEmployeeRequisitionProfile(Integer employeeId) {
            Session session = this.sessionFactory.getCurrentSession();
            List<Requisition> employeeRequisitionProfile = (List<Requisition>) session.createQuery("SELECT o from Requisition o WHERE o.employee.id=:employeeId").setParameter("employeeId", employeeId).list();
            return employeeRequisitionProfile;
        }
        
        @SuppressWarnings("unchecked")
	@Override
	public List<Requisition> listRequisition() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Requisition> requisitionList = session.createQuery("from Requisition").list();
		return requisitionList;
	}
        
        @SuppressWarnings("unchecked")
        @Override
        public List<Requisition> listPendingRequisition() {
                Session session = this.sessionFactory.getCurrentSession();
                List<Requisition> pendingRequisitionList = session.createQuery("SELECT o from Requisition o WHERE o.status='pending'").list();
                return pendingRequisitionList;
        }
        
	@Override
	public Requisition getRequisitionById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		Requisition r = (Requisition) session.load(Requisition.class, new Integer(id));
		logger.info("Requisition loaded successfully, Requisition details="+r);
		return r;
	}
        
        @Override
	public void deleteRequisition(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Requisition r = (Requisition) session.load(Requisition.class, new Integer(id));
		if(null != r){
			session.delete(r);
		}
		logger.info("Requisition deleted successfully, Requisition details="+r);
	}
	
        @Override
        public void updateStatus(String status, Integer requisitionId) {
                Session session = this.sessionFactory.getCurrentSession();
                Requisition r = (Requisition) session.load(Requisition.class, new Integer(requisitionId));
                r.setStatus(status);
                session.update(r);

    }

}


