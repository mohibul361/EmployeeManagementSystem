<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body> 
   
<c:set var="actionUrl" value="${pageContext.request.contextPath}/approveLeave/${leave.id}" />    
<form:form action="${actionUrl}" modelAttribute="leave" method="POST">
<table align="left" width="100%" style="border:1px solid black;
                                        background-color:whitesmoke">
    
    <h1 style="background-color:whitesmoke">
       Leave Info
    </h1>  
        
    <tr colspan="2">
        <td>Employee Name</td>
         <td>${leave.employee.name}</td>
         
     </tr> 
      <tr>
          <td>Leave Type</td>
         <td>${leave.leaveType.name}</td> 
        </tr>  
        <tr>
         <td>From Date</td>
         <td>${leave.fromDate}</td>  
         <td>To Date</td>
         <td>${leave.toDate}</td>
         <td>Total Day</td>
         <td>${leave.totalDay}</td>
     </tr> 
     <tr> 
         <td>Date Of Application</td>
         <td>${leave.dateOfApplication}</td>
         <td>Description</td>
         <td>${leave.description}</td> 
     </tr> 
     <tr>
         <td>Status</td>
         <td>${leave.status}</td>  
     </tr> 
     <tr>
         <td ><input type="submit" name="approve" value="Approve"/> </td>
         <td ><input type="submit" name="reject" value="Reject"/> &nbsp; &nbsp; &nbsp;<b><a href="/Sencillo/pendingLeaveList.html" >List Of Pending Leave</a></b></td>
     </tr>
       
   </table> 
   </form:form>
 </body> 
 </head>
 