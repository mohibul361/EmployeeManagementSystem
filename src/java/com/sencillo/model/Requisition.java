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
    
@Entity(name= "Requisition")
@Table(name = "requisition")
public class Requisition implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank
    @Size(min=5,message="Enter Minimum 5 characters")
    @Column(name = "itemName", nullable = false)
    private String itemName;
    
    @NotNull
    @Size(min=1,message="Enter Minimum 1 digit")
    @Column(name = "quantity", nullable = false)
    private String quantity;
    
    @NotNull
    @Size(min=1,message="Enter Minimum 1 characters")
    @Column(name = "unit", nullable = false)
    private String unit;
    
    @NotBlank
    @Size(min=4,message="Enter Minimum 4 characters")
    @Column(name = "description", nullable = false)
    private String description;
    
    @NotNull
    @Size(min=3, message="Enter Minimum 3 characters")
    @Column(name = "amount", nullable = false)
    private String amount;
    
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "applyDate", nullable = false)
    private Date applyDate;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @ManyToOne
    @JoinColumn(name="employee_id",nullable=true)
    private Employee employee;
    
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id= id;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description= description;
    }
    
    
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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
		Requisition other = (Requisition) obj;
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
            return "Requisition [id=" + id + ", itemName=" + itemName + ", qantity=" + quantity + ", unit=" + unit + ", description= " +description + ", amount=" + amount + ", applyDate=" + applyDate + ", status=" + status + ", employee=" + employee + "]";
	}
}

