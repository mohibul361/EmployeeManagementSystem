package com.sencillo.model;

import java.io.Serializable;
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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
    
@Entity
@Table(name = "department")
public class Department implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    
    @NotBlank
    @Size(min=5,message="Enter Minimum 5 characters")
    @Column(name = "departmentName", nullable = false)
    private String departmentName;
    
    @Size(min = 5, max = 25, message="Enter Valid and Unique Email" )
    @Pattern(regexp="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(name = "departmentEmail", unique=true)
    private String departmentEmail;
    
    @Size(min=11, max=11, message="Enter 11 digit")
    @Pattern(regexp="^[0-9]*$")
    @Column(name = "departmentPhoneNo", nullable = false)
    private String departmentPhoneNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id= id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getDepartmentEmail() {
        return departmentEmail;
    }

    public void setDepartmentEmail(String departmentEmail) {
        this.departmentEmail = departmentEmail;
    }
    
    public String getDepartmentPhoneNo() {
        return departmentPhoneNo;
    }

    public void setDepartmentPhoneNo(String departmentPhoneNo) {
        this.departmentPhoneNo = departmentPhoneNo;
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
		Department other = (Department) obj;
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
            return "Department [id=" + id + ", departmentName=" + departmentName + ", departmentEmail=" + departmentEmail + ",departmentPhoneNo=" + departmentPhoneNo + "]";
	}
}



