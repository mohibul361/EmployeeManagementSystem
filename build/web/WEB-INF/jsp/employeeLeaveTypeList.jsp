<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee Leave Type List</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    background-color:whitesmoke;
}
th, td {
    padding: 5px;
    text-align: left;
}
</style>
</head>
<body>
    <h1>List Of Leave Type</h1>
    <c:if test="${empty leaveType}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty leaveType}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Name</th>
   <th>Description</th>
   <th>Maximum Days</th>
  </tr>

  <c:forEach items="${employeeLeaveTypeList}" var="leaveType">
   <tr>
    <td><c:out value="${leaveType.id}"/></td>
    <td><c:out value="${leaveType.name}"/></td>
    <td><c:out value="${leaveType.description}"/></td>
    <td><c:out value="${leaveType.numberDaysAllowed}"/></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
</table>
</body>
</html>