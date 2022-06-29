package com.sencillo.dao;

import com.sencillo.model.Employee;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sencillo.model.GradeType;

@Repository
public class GradeTypeDaoImpl implements GradeTypeDao
{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public GradeType getGradeType(int id)
	{
		GradeType gradeType = (GradeType) getCurrentSession().load(GradeType.class, id);
		return gradeType;
	}

	@Override
	public void Save(GradeType gradeType)
	{
		this.getCurrentSession().save(gradeType);
	}

	@Override
	public void Edit(GradeType gradeType)
	{
		this.getCurrentSession().update(gradeType);
	}

	@Override
	public List<GradeType> getGradeTypeList()
	{
		@SuppressWarnings("unchecked")
		List<GradeType> list = sessionFactory.getCurrentSession().createQuery("from GradeType").list();
		return list;
	}

        @Override
	public Double getGradeTypeSalaryByEmployee(Integer id)
	{
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
                if(employee.getGradeType() != null)
                {
                    return new Double(""+employee.getGradeType().getgradeSalary());
                }
                else
                {
                    return 0d;
                }
	
		
	}
}