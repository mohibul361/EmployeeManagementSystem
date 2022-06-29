<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Department</title>
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
    <h1>List Department</h1>
    <c:if test="${empty department}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty department}">
 <table align="left" width="100%">
  <tr>
   <th>Department ID</th>
   <th>Department Name</th>
   <th>Department Email</th>
   <th>Department Phone Number</th>
   
                        <th></th>
                        <th></th>
  </tr>

  <c:forEach items="${departmentList}" var="department">
   <tr>
    <td><c:out value="${department.id}"/></td>
    <td><c:out value="${department.departmentName}"/></td>
    <td><c:out value="${department.departmentEmail}"/></td>
    <td><c:out value="${department.departmentPhoneNo}"/></td>
   
                                <td><b><a href="<c:url value='/department/edit/${department.id}' />">Edit</a></b></td>
                                <td><b><a href="<c:url value='/department/delete/${department.id}' />">Delete</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: 1px black solid;">

<tr>
  <td style="padding : 1px; border: none;"><h3><a href="/Sencillo/department/add">Add More Department</a></h3></td>
</tr>
</table>
</body>
</html>