package com.sencillo.service;

import com.sencillo.dao.PromotionDao;
import com.sencillo.model.Designation;
import com.sencillo.model.Promotion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PromotionServiceImpl implements PromotionService
{     

	@Autowired
	private  PromotionDao promotionDao;
	
        public void setPromotionDao(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}
        
        @Override
	@Transactional
	public void updatePromotion(Promotion p) {
		this.promotionDao.updatePromotion(p);
	}
        
        @Override
	@Transactional
	public List<Promotion> listPromotion() {
		return this.promotionDao.listPromotion();
	}
        
        @Override
	@Transactional
	public List<Promotion> listPendingPromotion() {
		return this.promotionDao.listPendingPromotion();
	}
        
        @Override
	@Transactional
	public List<Promotion> listEmployeePromotionProfile(Integer employeeId) {
		return this.promotionDao.listEmployeePromotionProfile(employeeId);
	}

        @Override
	@Transactional
	public void addPromotion(Promotion p) {
		this.promotionDao.addPromotion(p);
	}
        
        @Override
        public void updateStatus(String status, Integer promotionId)  {
                this.promotionDao.updateStatus(status, promotionId);
        }
        
        @Override
        public void updateDesignation(Promotion p)  {
                this.promotionDao.updateDesignation(p);
        }
        
	@Override
	@Transactional
	public Promotion getPromotionById(int id) {
		return this.promotionDao.getPromotionById(id);
        }
        
        @Override
	@Transactional
	public void deletePromotion(int id) {
		this.promotionDao.deletePromotion(id);
	}
   	
}

 

