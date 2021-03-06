package com.sencillo.model;

import java.io.Serializable;
import java.time.Year;
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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="leavetype")
public class LeaveType implements Serializable {
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank
    @Size(min=5,message="Enter Minimum 5 characters")
    @Column(name = "name", nullable = false)
    private String name;
    
    @NotBlank
    @Size(min=5,message="Enter Minimum 5 characters")
    @Column(name = "description", nullable = false)
    private String description;
    
    @Size(min=1,message="Enter Minimum 4 Digit")
    @Pattern(regexp="[0-9]+")
    @Column(name = "numberDaysAllowed", nullable = false)
    private Integer numberDaysAllowed; 
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getNumberDaysAllowed() {
        return numberDaysAllowed;
    }

    public void setNumberDaysAllowed(Integer numberDaysAllowed) {
        this.numberDaysAllowed = numberDaysAllowed;
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
		LeaveType other = (LeaveType) obj;
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
            return "LeaveType [id=" + id + ", name=" + name + ", description=" + description + ", numberDaysAllowed=" + numberDaysAllowed + "]";
	}
}

        


