package com.sencillo.dao;

import java.util.List;
import com.sencillo.model.Requisition;

public interface RequisitionDao
{
	public void addRequisition(Requisition r);
        public void updateRequisition(Requisition r);
        public List<Requisition> listRequisition();
        public List<Requisition> listPendingRequisition();
        public List<Requisition> listEmployeeRequisitionProfile(Integer employeeId);
        public Requisition getRequisitionById(int id);
        public void deleteRequisition(int id);
        public void updateStatus(String status, Integer requisitionId) ;
}
