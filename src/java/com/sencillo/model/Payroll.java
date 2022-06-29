package com.sencillo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "payroll")
public class Payroll implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name = "gradeSalary", nullable = false)
    private Double gradeSalary;
    
    @NotNull
    @Column(name = "houseRentAllowance", nullable = false)
    private Double houseRentAllowance;
        
    @NotNull
    @Column(name = "festivalAllowance", nullable = false)
    private Double festivalAllowance;

    @NotNull
    @Column(name = "medicalAllowance", nullable = false)
    private Double medicalAllowance;
      
    @NotNull
    @Column(name = "transportAllowance", nullable = false)
    private Double transportAllowance;
    
    @NotNull
    @Column(name = "providentFund", nullable = false)
    private Double providentFund;

    @NotNull
    @Column(name = "taxDeduction", nullable = false)
    private Double taxDeduction;
    
    @NotNull
    @Column(name = "otherDeduction", nullable = false)
    private Double otherDeduction;
    

    @Column(name = "penalty", nullable = false)
    private Double penalty;

    @NotBlank
    @Column(name = "month", nullable = false)
    private String month;

    @NotBlank
    @Column(name = "year", nullable = false)
    private String year;   
    
//    @Formula("houseRentAllowance+medicalAllowance+tiffinAllowance+dearnessAllowance+festivalAllowance+transportAllowance-taxDeduction-otherDeduction-penalty-providentFund")
    @Column(name = "totalAllowance", nullable = false)
    private Double totalAllowance;

    @Column(name = "totalDeduction", nullable = false)
    private Double totalDeduction;
    
//    @Formula("calculatedSalary+gradeType_id")
    @Column(name="monthlySalary", nullable = false)
    private Double monthlySalary;
    
    
    @ManyToOne
    @JoinColumn(name="employee_id",nullable=true)
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGradeSalary() {
        return gradeSalary;
    }

    public void setGradeSalary(Double gradeSalary) {
        this.gradeSalary = gradeSalary;
    }

    public Double getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(Double houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }

    public Double getFestivalAllowance() {
        return festivalAllowance;
    }

    public void setFestivalAllowance(Double festivalAllowance) {
        this.festivalAllowance = festivalAllowance;
    }

    public Double getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(Double medicalAllowance) {
        this.medicalAllowance = medicalAllowance;
    }

    public Double getTransportAllowance() {
        return transportAllowance;
    }

    public void setTransportAllowance(Double transportAllowance) {
        this.transportAllowance = transportAllowance;
    }

    public Double getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(Double providentFund) {
        this.providentFund = providentFund;
    }

    public Double getTaxDeduction() {
        return taxDeduction;
    }

    public void setTaxDeduction(Double taxDeduction) {
        this.taxDeduction = taxDeduction;
    }

    public Double getOtherDeduction() {
        return otherDeduction;
    }

    public void setOtherDeduction(Double otherDeduction) {
        this.otherDeduction = otherDeduction;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getTotalAllowance() {
        return totalAllowance;
    }

    public void setTotalAllowance(Double totalAllowance) {
        this.totalAllowance = totalAllowance;
    }

    public Double getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(Double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    
    
    @Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payroll other = (Payroll) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
            //return "Payroll [id=" + id + ", monthlySalary=" + monthlySalary + ", houseRentAllowance=" +houseRentAllowance + ", transportAllowance=" + transportAllowance + ", festivalAllowance=" + festivalAllowance +" medicalAllowance=" + medicalAllowance + ", providentFund=" + providentFund + ", penalty=" + penalty + ", taxDeduction=" + taxDeduction + ", otherDeduction=" + otherDeduction + ", totalAllowance="+ totalAllowance", totalDeduction="+ totalDeduction +", month=" + month + ", year =" + year + ",gradeSalary=" + gradeSalary + ", employee=" + employee +"]";
            return null;
	}
}
