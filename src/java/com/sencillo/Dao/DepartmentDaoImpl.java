package com.sencillo.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao
{
        private static final Logger logger = LoggerFactory.getLogger(DepartmentDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
        public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        @Override
	public void addDepartment(Department d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Department saved successfully, Department Details="+d);
	}
        @Override
	public void updateDepartment(Department d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("Department updated successfully, Department Details="+d);
	}
        @SuppressWarnings("unchecked")
	@Override
	public List<Department> listDepartment() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Department> departmentList = session.createQuery("from Department").list();
		return departmentList;
	}
        
	@Override
	public Department getDepartmentById(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();		
		Department d = (Department) session.load(Department.class, new Integer(id));
		logger.info("Department loaded successfully, Department details="+d);
		return d;
	}
        
        @Override
	public Department getDepartment(String email)
	{
                Session session = this.sessionFactory.getCurrentSession();
		Department department = (Department) session.createQuery("SELECT o from Department o WHERE o.departmentEmail=:departmentEmail").setParameter("departmentEmail", email).uniqueResult();
		return  department;
	}
        
        @Override
	public void deleteDepartment(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Department d = (Department) session.load(Department.class, new Integer(id));
		if(null != d){
			session.delete(d);
		}
		logger.info("Department deleted successfully, Department details="+d);
	}
	

}

