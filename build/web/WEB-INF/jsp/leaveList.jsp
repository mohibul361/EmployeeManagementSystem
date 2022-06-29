<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Leave</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    background-color: whitesmoke;
}
th, td {
    padding: 5px;
    text-align: left;
}
</style>
</head>
<body>
    <h1>List Of Leave</h1>
    <c:if test="${empty leave}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty leave}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Employee Name</th>
   <th>Leave Type</th>
   <th>From Date</th>
   <th>To Date</th>
   <th>Total Day</th>
   <th>Date Of Application</th>
   <th>Description</th>
   <th>Status</th>
   <th>Action</th>
                
  </tr>

  <c:forEach items="${leaveList}" var="leave">
   <tr>
    <td><c:out value="${leave.id}"/></td>
    <td><c:out value="${leave.employee.name}"/></td>
    <td><c:out value="${leave.leaveType.name}"/></td>
    <td><c:out value="${leave.toDate}"/></td>
    <td><c:out value="${leave.fromDate}"/></td>
    <td><c:out value="${leave.totalDay}"/></td>
    <td><c:out value="${leave.dateOfApplication}"/></td>
    <td><c:out value="${leave.description}"/></td>
    <td><c:out value="${leave.status}"/></td>
               <td><b><a href="<c:url value='/leave/delete/${leave.id}' />">Delete</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
</body>
</html>