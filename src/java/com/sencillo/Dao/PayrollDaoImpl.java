package com.sencillo.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Payroll;

@Repository
public class PayrollDaoImpl implements PayrollDao
{
        private static final Logger logger = LoggerFactory.getLogger(PayrollDaoImpl.class);
        
	@Autowired
	private SessionFactory sessionFactory;
        public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        
        @Override
	public void addPayroll(Payroll p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Payroll saved successfully, Payroll Details="+p);
	}
        
        @Override
	public void updatePayroll(Payroll p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Payroll updated successfully, Payroll Details="+p);
	}
        @SuppressWarnings("unchecked")
	@Override
	public List<Payroll> listPayroll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Payroll> payrollList = session.createQuery("from Payroll").list();
		for(Payroll p : payrollList){
			logger.info("Payroll List::"+p);
		}
		return payrollList;
	}
        
        @SuppressWarnings("unchecked")
        @Override
        public List<Payroll> listEmployeePayrollProfile(Integer employeeId) {
            Session session = this.sessionFactory.getCurrentSession();
            List<Payroll> employeePayrollProfile = (List<Payroll>) session.createQuery("SELECT o from Payroll o WHERE o.employee.id=:employeeId").setParameter("employeeId", employeeId).list();
            return employeePayrollProfile;
        }
        
	@Override
	public Payroll getPayrollById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		Payroll p = (Payroll) session.load(Payroll.class, new Integer (id));
		logger.info("Payroll loaded successfully, Payroll details="+p);
		return p;
	}
        
        @Override
	public void deletePayroll(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Payroll p = (Payroll) session.load(Payroll.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Payroll deleted successfully, Payroll details="+p);
	}
        
}

