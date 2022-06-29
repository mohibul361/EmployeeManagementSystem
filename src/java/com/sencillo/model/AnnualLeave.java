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

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="annualleave")
public class AnnualLeave implements Serializable {
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateUpdated;

    @Column(name = "leaveDaysAllowed", nullable = false)
    private Integer leaveDaysAllowed;
    

    @Column(name = "cummulativeDaysTaken", nullable = false)
    private Integer cummulativeDaysTaken;
    
    @Column(name = "remainingDays", nullable = false)
    private Integer remainingDays;
    
    @Column(name = "year", nullable = false)
    private Integer year;
    
    @ManyToOne
    @JoinColumn(name="employee_id",nullable=true)
    private Employee employee;  
    
    @ManyToOne
    @JoinColumn(name="leaveType_id",nullable=true)
    private LeaveType leaveType; 
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    
    public Integer getLeaveDaysAllowed() {
        return leaveDaysAllowed;
    }

    public void setLeaveDaysAllowed(Integer leaveDaysAllowed) {
        this.leaveDaysAllowed = leaveDaysAllowed;
    }
    
    public Integer getCummulativeDaysTaken() {
        return cummulativeDaysTaken;
    }

    public void setCummulativeDaysTaken(Integer cummulativeDaysTaken) {
        this.cummulativeDaysTaken = cummulativeDaysTaken;
    }
    
    public Integer getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Integer remainingDays) {
        this.remainingDays = remainingDays;
    }
    
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
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
		AnnualLeave other = (AnnualLeave) obj;
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
            return "AnnualLeave [id=" + id + ", dateUpdated=" + dateUpdated + ", leaveDaysAllowed=" + leaveDaysAllowed + ", cummulativeDaysTaken=" + cummulativeDaysTaken + ", remainingDays=" + remainingDays + ", year =" + year + ",employee=" + employee + ", leaveType=" + leaveType +"]";
	}
}

        


