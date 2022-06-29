<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Designation</title>
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
    <h1>List Of Designation</h1>
    <c:if test="${empty designation}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty designation}">
 <table align="left" width="100%">
  <tr>
   <th>Designation ID</th>
   <th>Designation Name</th>
                        <th></th>
                        <th></th>
  </tr>

  <c:forEach items="${designationList}" var="designation">
   <tr>
    <td><c:out value="${designation.id}"/></td>
    <td><c:out value="${designation.designationName}"/></td>
                                <td><b><a href="<c:url value='/designation/edit/${designation.id}' />">Edit</a></b></td>
                                <td><b><a href="<c:url value='/designation/delete/${designation.id}' />">Delete</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
 <tr>
  <td style="padding : none; border: none;"><h3><a href="/Sencillo/designation/add">Add More Designation</a></h3></td>
 </tr>
</table>
</body>
</html>