package com.sencillo.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    @Size(min=6,message="Enter Minimum 6 characters")
    @Column(name = "name", nullable = false)
    private String name;

//    @NotBlank
    @Column(name = "status", nullable = false)
    private boolean status;
    
    @NotBlank
    @Size(min=5,message="Enter Minimum 5 characters")
    @Column(name = "presentAddress", nullable = false)
    private String presentAddress;

    @NotBlank
    @Size(min=5,message="Enter Minimum 5 characters")
    @Column(name = "permanentAddress", nullable = false)
    private String permanentAddress;
    
    @Size(min=11,max=11,message="Enter 11 digit")
    @Pattern(regexp="^[0-9]*$")
    @Column(name = "mobileNo", nullable = false)
    private String mobileNo;

    @NotNull
    @Size(min=17,max=17,message="Enter 17 digit")
    @Pattern(regexp="^[0-9]*$")
    @Column(name = "nid", nullable = false)
    private String nid;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Size(min = 1, max = 100, message="{email.size}")
    @Pattern(regexp="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(name = "email", unique=true, nullable = false)
    private String email;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @NotNull
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    @Past
    @Column(name = "dob", nullable = false)
    private Date dob;
    
    @ManyToOne
    @JoinColumn(name="department_id",nullable=true)
    private Department department;
    
    @ManyToOne
    @JoinColumn(name="designation_id", nullable=true)
    private Designation designation;
    
    @ManyToOne
    @JoinColumn(name="gradeType_id", nullable=true)
    private GradeType gradeType;
    
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
    
    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public Department getDepartment(){
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
     
    public Designation getDesignation(){
        return designation;
    }
    
    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
    
    public GradeType getGradeType(){
        return gradeType;
    }
    
    public void setGradeType(GradeType gradeType) {
        this.gradeType =gradeType;
    }
            

}
