package com.sencillo.service;

import com.sencillo.dao.DesignationDao;
import com.sencillo.model.Designation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DesignationServiceImpl implements DesignationService
{     

	@Autowired
	private  DesignationDao designationDao;
	
        public void setDesignationDao(DesignationDao designationDao) {
		this.designationDao = designationDao;
	}
        
        @Override
	@Transactional
	public void updateDesignation(Designation d) {
		this.designationDao.updateDesignation(d);
	}
        
        @Override
	@Transactional
	public List<Designation> listDesignation() {
		return this.designationDao.listDesignation();
	}

        
        @Override
	@Transactional
	public void addDesignation(Designation d) {
		this.designationDao.addDesignation(d);
	}
        
	@Override
	@Transactional
	public Designation getDesignationById(int id) {
		return this.designationDao.getDesignationById(id);
        }
        
        @Override
	@Transactional
	public void deleteDesignation(int id) {
		this.designationDao.deleteDesignation(id);
	}
        
	
}

 
