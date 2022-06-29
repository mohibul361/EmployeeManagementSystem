package com.sencillo.service;

import com.sencillo.model.Requisition;
import java.util.List;

public interface RequisitionService
{
	public void addRequisition(Requisition r);
        public void updateRequisition(Requisition r);
        public List<Requisition> listRequisition();
        public List<Requisition> listPendingRequisition();
        public List<Requisition> listEmployeeRequisitionProfile(Integer employeeId);
        public Requisition getRequisitionById(int id);
        public void deleteRequisition(int id);
        public void updateStatus(String status, Integer requisitionId);
}
