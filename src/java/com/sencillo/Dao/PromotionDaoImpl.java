package com.sencillo.dao;
import com.sencillo.model.Designation;
import com.sencillo.model.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Promotion;

@Repository
public class PromotionDaoImpl implements PromotionDao
{
        private static final Logger logger = LoggerFactory.getLogger(PromotionDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
        public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        @Override
	public void addPromotion(Promotion p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Promotion saved successfully, Promotion Details="+p);
	}
        @Override
	public void updatePromotion(Promotion p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Promotion updated successfully, Promotion Details="+p);
	}
        @SuppressWarnings("unchecked")
	@Override
	public List<Promotion> listPromotion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Promotion> promotionList = session.createQuery("from Promotion").list();
		for(Promotion p : promotionList){
			logger.info("Promotion List::"+p);
		}
		return promotionList;
	}
        
        @SuppressWarnings("unchecked")
	@Override
	public List<Promotion> listPendingPromotion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Promotion> pendingPromotionList = session.createQuery("SELECT o from Promotion o WHERE o.status='pending'").list();
		return pendingPromotionList;
	}
        
        @SuppressWarnings("unchecked")
        @Override
        public List<Promotion> listEmployeePromotionProfile(Integer employeeId) {
            Session session = this.sessionFactory.getCurrentSession();
            List<Promotion> employeePromotionProfile = (List<Promotion>) session.createQuery("SELECT o from Promotion o WHERE o.employee.id=:employeeId").setParameter("employeeId", employeeId).list();
            System.out.println("employeePromotionProfile.size() = " + employeePromotionProfile.size());
            return employeePromotionProfile;
        }
        
	@Override
	public Promotion getPromotionById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		Promotion p = (Promotion) session.load(Promotion.class, new Integer(id));
		logger.info("Promotion loaded successfully, Promotion details="+p);
		return p;
	}
        @Override
	public void deletePromotion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Promotion p = (Promotion) session.load(Promotion.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Promotion deleted successfully, Promotion details="+p);
	}
        
        @Override
        public void updateStatus(String status, Integer promotionId) {
            Session session = this.sessionFactory.getCurrentSession();
            Promotion p = (Promotion) session.load(Promotion.class, new Integer(promotionId));
            p.setStatus(status);
            session.update(p); 
        }
        
        @Override
        public void updateDesignation(Promotion p){
            Session session = this.sessionFactory.getCurrentSession();
            Promotion promotion = (Promotion) session.load(Promotion.class, p.getId());
            Employee  employee = (Employee) session.load(Employee.class, promotion.getEmployee().getId());
            employee.setDesignation(promotion.getDesignation());
            session.update(employee);   
        }
	
}

