<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee Profile</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
</style>
</head>
<body>
    <h1>Employee Profile</h1>
   <table align="left" width="100%" style="border:none">
     <tr>
         <td>Name</td>
         <td>${employee.name}</td>  
         <td>Email</td>
         <td>${employee.email}</td>
     </tr> 
      <tr>
         <td>Mobile</td>
         <td>${employee.mobileNo}</td>  
         <td>NID</td>
         <td>${employee.nid}</td>
     </tr> 
     <tr>
         <td>Grade Name</td>
         <td>${employee.gradeType.name}</td>
         <td>Permanent Address</td>
         <td>${employee.permanentAddress}</td>
     </tr> 
     <tr>
         <td>Gender</td>
         <td>${employee.gender}</td>  
         <td>Status</td>
         <td>${employee.status}</td>
     </tr> 
     <tr>
         <td>Department Name</td>
         <td>${employee.department.departmentName}</td>  
         <td>Designation Name</td>
         <td>${employee.designation.designationName}</td>
     </tr> 
     <tr>
            <td><a href="<c:url value='/employee/edit/${employee.id}'/>">Edit</a></td>
        </tr>
   </table>
     
</body>
</html>