package com.sencillo.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Employee;
import com.sencillo.model.User;

@Repository
public class EmployerDaoImpl implements EmployerDao
{
        private static final Logger logger = LoggerFactory.getLogger(EmployerDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
        public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        
        @Override
	public void addEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		logger.info("Employee saved successfully, Employee Details="+e);
	}
        
        @Override
	public void updateEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		logger.info("Employee updated successfully, Employee Details="+e);
	}
        @SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployee() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		
		return employeeList;
	}
        
	@Override
	public Employee getEmployeeById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		logger.info("Employee loaded successfully, Employee details="+e);
		return e;
	}
        
        @Override
	public void deleteEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		if(null != e){
			session.delete(e);
		}
		logger.info("Employee deleted successfully, employee details="+e);
	}
        
        @Override
	public Employee getEmployee(String email)
	{
                Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.createQuery("SELECT o from Employee o WHERE o.email=:email").setParameter("email", email).uniqueResult();
		return  employee;
	}
	

}

