<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
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

    <h1>List Of Employees</h1>
    <c:if test="${empty employee}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty employee}">
 <table align="left" width="100%">
  <tr>
   <th> ID</th>
   <th> Name</th>
   <th>Designation Name</th>
   <th>Department Name</th>
   <th> Permanent Address</th>
   <th> Gender </th>
   <th> Status</th>
   <th> Email</th>
   <th> NID</th>
   <th> Mobile Number</th>
   <th> Joining Date</th>
   <th> Date Of Birth</th>  
   <th>Grade Name</th>
                        <th></th>
                        <th></th>
  </tr>

  <c:forEach items="${empList}" var="employee">
   <tr>
    <td><c:out value="${employee.id}"/></td>
    <td><c:out value="${employee.name}"/></td>
    <td><c:out value="${employee.designation.designationName}"/></td> 
    <td><c:out value="${employee.department.departmentName}"/></td>
    <td><c:out value="${employee.permanentAddress}"/></td>
    <td><c:out value="${employee.gender}"/></td>
    <td><c:out value="${employee.status}"/></td> 
    <td><c:out value="${employee.email}"/></td> 
    <td><c:out value="${employee.nid}"/></td> 
    <td><c:out value="${employee.mobileNo}"/></td> 
    <td><c:out value="${employee.joiningDate}"/></td> 
    <td><c:out value="${employee.dob}"/></td> 
    <td><c:out value="${employee.gradeType.name}"/></td>
                                <td><b><a href="<c:url value='/employee/edit/${employee.id}' />">Edit</a></b></td>
                                <td><b><a href="<c:url value='/employee/delete/${employee.id}' />">Delete</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
 <tr>
  <td style="padding: none;"><h3><a href="/Sencillo/employee/add">Add More Employee</a></h3></td>
 </tr>
</table>
</body>
</html>