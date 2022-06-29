package com.sencillo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "salary")
public class Salary implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull   
    @DateTimeFormat(pattern = "dd/mm/yyyy")    
    @Temporal(TemporalType.DATE)
    @Column(name = "salaryEffectiveDate", nullable = false)
    private Date salaryEffectiveDate;

    @Size(min=5,message="Enter minimum 5 digit")
    @Pattern(regexp="^0-9*$")
    @Column(name = "totalSalary", nullable = false)
    private String monthlySalary;
    
    @Size(min=13, max=13,message="Enter minimum 13 digit")
    @Pattern(regexp="^0-9*$")
    @Column(name = "bankAccountNumber", nullable = false)
    private String bankAccountNumber;
    
    @Size(min=3, message="Enter minimum 3 digit")
    @Column(name = "bankName", nullable = false)
    private String bankName;
    
    @Size(min=4, message="Enter minimum 4 digit")
    @Column(name = "bankBranchName", nullable = false)
    private String bankBranchName;

    @Size(min=9, max=9,message="Enter minimum 9 digit")
    @Pattern(regexp="^0-9*$")
    @Column(name = "taxIdentificationNumber", nullable = false)
    private String taxIdentificationNumber;
    
    @ManyToOne
    @JoinColumn(name="employee_id",nullable=true)
    private Employee employee;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getSalaryEffectiveDate() {
        return salaryEffectiveDate;
    }

    public void setSalaryEffectiveDate(Date salaryEffectiveDate) {
        this.salaryEffectiveDate = salaryEffectiveDate;
    }
    
    public String getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(String monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }
    
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
    
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }
    
    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
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
		Salary other = (Salary) obj;
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
            return "Salary [id=" + id + ", monthlySalary=" + monthlySalary + ", salaryEffectiveDate=" + salaryEffectiveDate + ", bankAccountNumber=" + bankAccountNumber + ", bankName=" + bankName + ", bankBranchName=" + bankBranchName + ", taxIdentificationNumber=" + taxIdentificationNumber + ", employee=" + employee +"]";
	}
}

