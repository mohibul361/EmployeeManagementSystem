<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Pending Requisition</title>
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
    <h1>List Of Pending Requisition</h1>
    <c:if test="${empty requisition}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty requisition}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Employee Name</th>
   <th>Item Name</th>
   <th>Quantity</th>
   <th>Unit</th>
   <th>Description</th>
   <th>Amount</th>
   <th>Apply Date</th>
   <th>Status</th>
   <th>Action</th>
  </tr>

  <c:forEach items="${pendingRequisitionList}" var="requisition">
   <tr>
    <td><c:out value="${requisition.id}"/></td>
    <td><c:out value="${requisition.employee.name}"/></td>
    <td><c:out value="${requisition.itemName}"/></td>
    <td><c:out value="${requisition.quantity}"/></td>
    <td><c:out value="${requisition.unit}"/></td>
    <td><c:out value="${requisition.description}"/></td>
    <td><c:out value="${requisition.amount}"/></td>
    <td><c:out value="${requisition.applyDate}"/></td>
    <td><c:out value="${requisition.status}"/></td>

                            <td><b><a href="<c:url value='/approveRequisition/${requisition.id}' />">View</a></b></td>
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