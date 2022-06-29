<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Holiday List</title>
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
    <h1>List Of Holiday</h1>
    <c:if test="${empty holiday}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty holiday}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Holiday Name</th>
   <th>From Date</th>
   <th>To Date</th>
   <th>Description</th>
   
                        <th></th>
                        <th></th>
  </tr>

  <c:forEach items="${holidayList}" var="holiday">
   <tr>
    <td><c:out value="${holiday.id}"/></td>
    <td><c:out value="${holiday.holidayName}"/></td>
    <td><c:out value="${holiday.fromDate}"/></td>
    <td><c:out value="${holiday.toDate}"/></td>
    <td><c:out value="${holiday.description}"/></td>
   
                                <td><b><a href="<c:url value='/holiday/edit/${holiday.id}' />">Edit</a></b></td>
                                <td><b><a href="<c:url value='/holiday/delete/${holiday.id}' />">Delete</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
 <tr>
  <td style="padding : none; border: none;"><h3><a href="/Sencillo/holiday/add">Add More Holiday</a></h3></td>
 </tr>
</table>
</body>
</html>