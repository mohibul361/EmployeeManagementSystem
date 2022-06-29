package com.sencillo.service;

import com.sencillo.model.Designation;
import com.sencillo.model.Promotion;
import java.util.List;

public interface PromotionService
{
	public void addPromotion(Promotion p);
        public void updatePromotion(Promotion p);
        public List<Promotion> listPromotion();
        public List<Promotion> listPendingPromotion();
        public List<Promotion> listEmployeePromotionProfile(Integer employeeId);
        public Promotion getPromotionById(int id);
        public void deletePromotion(int id);
        public void updateStatus(String status, Integer promotionId);
        public void updateDesignation(Promotion p) ;
}
