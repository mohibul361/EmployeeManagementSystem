<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Attendance</title>
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
    <h1>List Attendance</h1>
    <c:if test="${empty attendance}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty attendance}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Date</th>
   <th>Status</th>
   <th>Employee Name</th>
   
                        <th></th>
                        <th></th>
  </tr>

  <c:forEach items="${attendanceList}" var="attendance">
   <tr>
    <td><c:out value="${attendance.id}"/></td>
    <td><c:out value="${attendance.date}"/></td>
    <td><c:out value="${attendance.status}"/></td>
    <td><c:out value="${attendance.employee.name}"/></td>
    
                                <td><b><a href="<c:url value='/attendance/edit/${attendance.id}' />">Edit</a></b></td>
                                <td><b><a href="<c:url value='/attendance/delete/${attendance.id}' />">Delete</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
 <tr>
  <td style="padding : none; border: none;"><h3><a href="/Sencillo/attendance/add">Add More Attendance</a></h3></td>
 </tr>
</table>
</body>
</html>