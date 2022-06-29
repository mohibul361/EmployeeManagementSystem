package com.sencillo.service;

import java.util.List;

import com.sencillo.model.GradeType;

public interface GradeTypeService
{
	public GradeType getGradeType(int id);
	public void Save(GradeType gradeType);
	public void Edit(GradeType gradeType);
	public List<GradeType> getGradeTypeList();
        public Double getGradeTypeSalaryByEmployee(Integer id);
        
}

