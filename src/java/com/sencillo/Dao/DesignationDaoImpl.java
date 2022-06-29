package com.sencillo.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Designation;

@Repository
public class DesignationDaoImpl implements DesignationDao
{
        private static final Logger logger = LoggerFactory.getLogger(DesignationDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
        public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        @Override
	public void addDesignation(Designation d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Designation saved successfully, Designation Details="+d);
	}
        @Override
	public void updateDesignation(Designation d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("Designation updated successfully, Designation Details="+d);
	}
        @SuppressWarnings("unchecked")
	@Override
	public List<Designation> listDesignation() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Designation> designationList = session.createQuery("from Designation").list();
		for(Designation d : designationList){
			logger.info("Designation List::"+d);
		}
		return designationList;
	}
        
	@Override
	public Designation getDesignationById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		Designation d = (Designation) session.load(Designation.class, new Integer(id));
		logger.info("Designation loaded successfully, Designation details="+d);
		return d;
	}
        
        @Override
	public void deleteDesignation(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Designation d = (Designation) session.load(Designation.class, new Integer(id));
		if(null != d){
			session.delete(d);
		}
		logger.info("Designation deleted successfully, Designation details="+d);
	}
	

}

