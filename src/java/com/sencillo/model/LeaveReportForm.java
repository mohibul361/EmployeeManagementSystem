/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sencillo.model;

import java.util.Date;

/**
 *
 * @author Nabiha
 */
public class LeaveReportForm {
 
    private Date fromDate;
    private Date toDate;
//    private Integer employeeId;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

//    public Integer getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(Integer employeeId) {
//        this.employeeId = employeeId;
//    }
    
}
