package com.sencillo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
	
    @NotBlank
    @Column(name="user_name", nullable = false)
    private String userName;

	
    @NotBlank
    @Column(name="password", nullable = false)
    private String password;
	
    @Column(name="salt", nullable = false)
    private String salt;
	
    @Column(name="active", nullable = false)
    private boolean active; 
 
    @ManyToOne
    @JoinColumn(name="employee_id",nullable=true)
    private Employee employee;
    
    @ManyToOne
    @JoinColumn(name="role_id",nullable=true)
    private Role role;
	
    public Integer getId() {
		return id;
	}

    public void setId(Integer id) {
		this.id = id;
	}

	
    public String getPassword() {
		return password;
	}

    public void setPassword(String password) {
		this.password = password;
	}

    public String getSalt()
	{
		return salt;
	}

    public void setSalt(String salt)
	{
		this.salt = salt;
	}

    public String getUserName()
	{
		return userName;
	}

    public void setUserName(String userName)
	{
		this.userName = userName;
	}

    public boolean isActive()
	{
		return active;
	}

    public void setActive(boolean active)
	{
		this.active = active;
	}
        
    public Employee getEmployee()
	{
		return employee;
	}

    public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
        
    public Role getRole()
	{
		return role;
	}

    public void setRole(Role role)
	{
		this.role = role;
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
		User other = (User) obj;
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
		return "User [id=" + id + ", userName=" + userName + ", password=" +password + ",active=" + active + ", salt=" + salt +", employee=" + employee + ", role=" + role +"]";
	}
	
}