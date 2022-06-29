package com.sencillo.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Salary;

@Repository
public class SalaryDaoImpl implements SalaryDao
{
        private static final Logger logger = LoggerFactory.getLogger(SalaryDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
        public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        @Override
	public void addSalary(Salary s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(s);
		logger.info("Salary saved successfully, Salary Details="+s);
	}
        @Override
	public void updateSalary(Salary s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
		logger.info("Salary updated successfully, Salary Details="+s);
	}
        @SuppressWarnings("unchecked")
	@Override
	public List<Salary> listSalary() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Salary> salaryList = session.createQuery("from Salary").list();
		for(Salary s : salaryList){
			logger.info("Salary List::"+s);
		}
		return salaryList;
	}
        
	@Override
	public Salary getSalaryById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		Salary s = (Salary) session.load(Salary.class, new Integer(id));
		logger.info("Salary loaded successfully, Salary details="+s);
		return s;
	}
        @Override
	public void deleteSalary(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Salary s = (Salary) session.load(Salary.class, new Integer(id));
		if(null != s){
			session.delete(s);
		}
		logger.info("Salary deleted successfully, Salary details="+s);
	}
	

}

