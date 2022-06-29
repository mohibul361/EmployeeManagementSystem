<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Salary</title>
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
    <h1>List Salary</h1>
    <c:if test="${empty salary}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty salary}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Employee Name</th>
   <th>Monthly Salary</th>
   <th>Effective Date</th>
   <th>Bank Account Number</th>
   <th>Bank Name</th>
   <th>Bank Branch Name</th>
   <th>Tax Identification Number</th>
                        <th></th>
                        <th></th>
  </tr>

  <c:forEach items="${salaryList}" var="salary">
   <tr>
    <td><c:out value="${salary.id}"/></td>
    <td><c:out value="${salary.employee.name}"/></td>
    <td><c:out value="${salary.monthlySalary}"/></td>
    <td><c:out value="${salary.salaryEffectiveDate}"/></td>
    <td><c:out value="${salary.bankAccountNumber}"/></td>
    <td><c:out value="${salary.bankName}"/></td>
    <td><c:out value="${salary.bankBranchName}"/></td>
    <td><c:out value="${salary.taxIdentificationNumber}"/></td>
    
                                <td><b><a href="<c:url value='/salary/edit/${salary.id}' />">Edit</a></b></td>
                                <td><b><a href="<c:url value='/salary/delete/${salary.id}' />">Delete</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
 <tr>
  <td style="padding : none; border: none;"><h3><a href="/Sencillo/salary/add">Add More Salary</a></h3></td>
 </tr>
</table>
</body>
</html>
