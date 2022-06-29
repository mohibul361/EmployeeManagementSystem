package com.sencillo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sencillo.dao.GradeTypeDao;
import com.sencillo.model.GradeType;

@Service
@Transactional
public class GradeTypeServiceImpl implements GradeTypeService {

	@Autowired
	private GradeTypeDao gradeTypeDao;

        @Override
	public GradeType getGradeType(int id) {
		return gradeTypeDao.getGradeType(id);
	}

	@Override
	public void Save(GradeType gradeType)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Edit(GradeType gradeType)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GradeType> getGradeTypeList()
	{
		return this.gradeTypeDao.getGradeTypeList();
	}

        @Override
        public Double getGradeTypeSalaryByEmployee(Integer id)
        {
            return this.gradeTypeDao.getGradeTypeSalaryByEmployee(id);
        }
}