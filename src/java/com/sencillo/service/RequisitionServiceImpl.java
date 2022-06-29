package com.sencillo.service;

import com.sencillo.dao.RequisitionDao;
import com.sencillo.model.Requisition;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RequisitionServiceImpl implements RequisitionService
{     

	@Autowired
	private  RequisitionDao requisitionDao;
	
        public void setRequisitionDao(RequisitionDao requisitionDao) {
		this.requisitionDao = requisitionDao;
	}
        
        @Override
	@Transactional
	public void updateRequisition(Requisition r) {
		this.requisitionDao.updateRequisition(r);
	}
        
        @Override
	@Transactional
	public List<Requisition> listRequisition() {
		return this.requisitionDao.listRequisition();
	}

        @Override
        @Transactional
        public List<Requisition> listPendingRequisition() {
                return this.requisitionDao.listPendingRequisition();
        }
        
        @Override
	@Transactional
	public List<Requisition> listEmployeeRequisitionProfile(Integer employeeId) {
		return this.requisitionDao.listEmployeeRequisitionProfile(employeeId);
	}
        
        @Override
	@Transactional
	public void addRequisition(Requisition r) {
		this.requisitionDao.addRequisition(r);
	}
        
        @Override
        public void updateStatus(String status, Integer requisitionId)  {
                this.requisitionDao.updateStatus(status, requisitionId);

        }
        
	@Override
	@Transactional
	public Requisition getRequisitionById(int id) {
		return this.requisitionDao.getRequisitionById(id);
        }
        
        @Override
	@Transactional
	public void deleteRequisition(int id) {
		this.requisitionDao.deleteRequisition(id);
	}
        
	
}

 
