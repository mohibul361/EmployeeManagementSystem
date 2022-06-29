package com.sencillo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
    
@Entity(name= "Promotion")
@Table(name = "promotion")
public class Promotion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfApplication", nullable = false)
    private Date dateOfApplication;
    
   //@NotBlank
    @Column(name = "status", nullable = false)
    private String status;
    
    //@NotBlank
    @Column(name="designationDuringApplication")
    private String designationDuringApplication;
    
    //@NotBlank
    @Column(name="joinDate")
    private Date joinDate;
    
    @ManyToOne
    @JoinColumn(name="employee_id",nullable=true)
    private Employee employee;
    
    @ManyToOne
    @JoinColumn(name="designation_id",nullable=true)
    private Designation designation;
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id= id;
    }
    
    public Date getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Date dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }
    
    public String getDesignationDuringApplication() {
        return designationDuringApplication;
    }

    public void setDesignationDuringApplication(String designationDuringApplication) {
        this.designationDuringApplication = designationDuringApplication;
    }
    
    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Employee getEmployee(){
        
        return employee;
    }
    
    public void setEmployee(Employee employee){
        
        this.employee=employee;
    }
    
    public Designation getDesignation(){
        
        return designation;
    }
    
    public void setDesignation(Designation designation){
        
        this.designation=designation;
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
		Promotion other = (Promotion) obj;
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
            return "Promotion [id=" + id + ",dateOfApplication=" + dateOfApplication + ", designationDuringApplication=" + designationDuringApplication +", joinDate=" + joinDate +", status=" + status + ", employee=" + employee + ", designation="+ designation +" ]";
	}
}

