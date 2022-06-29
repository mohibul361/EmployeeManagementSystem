<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Promotion</title>
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
    <h1>List Of Personal Promotion Application</h1>
    <c:if test="${empty employeePromotionProfileList}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty employeePromotionProfileList}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Employee Name</th>
   <th>Apply Designation</th>
   <th>Designation During Application</th>
   <th>Date Of Application</th>
   <th>Status</th>
   <th>Employee Joining Date</th>
  </tr>

  <c:forEach items="${employeePromotionProfileList}" var="promotion">
   <tr>
    <td><c:out value="${promotion.id}"/></td>
    <td><c:out value="${promotion.employee.name}"/></td>
    <td><c:out value="${promotion.designation.designationName}"/></td>
    <td><c:out value="${promotion.designationDuringApplication}"/></td>
    <td><c:out value="${promotion.dateOfApplication}"/></td>
    <td><c:out value="${promotion.status}"/></td>
    <td><c:out value="${promotion.employee.joiningDate}"/></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
</table>
</body>
</html>