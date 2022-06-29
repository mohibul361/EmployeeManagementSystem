package com.sencillo.dao;

import com.sencillo.model.Designation;
import java.util.List;
import com.sencillo.model.Promotion;

public interface PromotionDao
{
	public void addPromotion(Promotion p);
        public void updatePromotion(Promotion p);
        public List<Promotion> listPromotion();
        public List<Promotion> listPendingPromotion();
        public List<Promotion> listEmployeePromotionProfile(Integer employeeId);
        public Promotion getPromotionById(int id);
        public void deletePromotion(int id);
        public void updateStatus(String status, Integer leaveId) ;
        public void updateDesignation(Promotion p) ;
}
