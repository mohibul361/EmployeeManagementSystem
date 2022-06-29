<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Pending Promotion</title>
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
    <h1>List Of Pending Promotion</h1>
    <c:if test="${empty promotion}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty promotion}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Employee Name</th>
   <th>Designation During Application</th>
   <th>Apply Designation Name</th>
   <th>Date Of Application</th>
   <th>Status</th>
   <th>Employee Joining Date</th>
   <th>Action</th>
  </tr>

  <c:forEach items="${pendingPromotionList}" var="promotion">
   <tr>
    <td><c:out value="${promotion.id}"/></td>
    <td><c:out value="${promotion.employee.name}"/></td>
    <td><c:out value="${promotion.designationDuringApplication}"/></td>
    <td><c:out value="${promotion.designation.designationName}"/></td>
    <td><c:out value="${promotion.dateOfApplication}"/></td>
    <td><c:out value="${promotion.status}"/></td>
    <td><c:out value="${promotion.employee.joiningDate}"/></td>

                            <td><b><a href="<c:url value='/approvePromotion/${promotion.id}' />">View</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
 <tr>
  <td style="padding : none; border: none;"><h3><a href="/Sencillo/promotion/add">Add More Promotion</a></h3></td>
 </tr>
</table>
</body>
</html>