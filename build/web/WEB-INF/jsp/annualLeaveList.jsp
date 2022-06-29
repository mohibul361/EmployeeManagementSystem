<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Annual Leave</title>
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
    <h1>List Of Annual Leave</h1>
    <c:if test="${empty annualLeave}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty annualLeave}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Employee Name</th>
   <th>Leave Name</th>
   <th>year</th>
   <th>Updated Date</th>
   <th>Maximum Days Allowed</th>
   <th>Cummulative Days Taken</th>
   <th>Remaining Days</th>
                        <th></th>
                        <th></th>
  </tr>

  <c:forEach items="${annualLeaveList}" var="annualLeave">
      <tr>
    <td><c:out value="${annualLeave.id}"/></td>
    <td><c:out value="${annualLeave.employee.name}"/></td>
    <td><c:out value="${annualLeave.leaveType.name}"/></td>
    <td><c:out value="${annualLeave.year}"/></td>
    <td><c:out value="${annualLeave.dateUpdated}"/></td>
    <td><c:out value="${annualLeave.leaveDaysAllowed}"/></td>
    <td><c:out value="${annualLeave.cummulativeDaysTaken}"/></td>
    <td><c:out value="${annualLeave.remainingDays}"/></td>
    
                                <td><b><a href="<c:url value='/annualLeave/edit/${annualLeave.id}' />">Edit</a></b></td>
                                <td><b><a href="<c:url value='/annualLeave/delete/${annualLeave.id}' />">Delete</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
 <tr>
  <td style="padding : none; border: none;"><h3><a href="/Sencillo/annualLeave/add">Add More Annual Leave</a></h3></td>
 </tr>
</table>
</body>
</html>