<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Payroll</title>
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
    <h1>List Of Payroll</h1>
    <c:if test="${empty payroll}">
       <h3>No Records found!</h3>
   </c:if>

    <c:if test="${!empty payroll}">
 <table align="left" width="100%">
  <tr>
   <th>ID</th>
   <th>Employee Name</th>
   <th>Grade Salary</th>
   <th>Year</th>
   <th>Month</th>
   <th>House Rent Allowance</th>
   <th>Festival Allowance</th>
   <th>Medical Allowance</th>
   <th>Transport Allowance</th>
   <th>Tax Deduction</th>
   <th>Other Deduction</th>
   <th>Provident Fund</th>
   <th>Penalty</th>
   <th>Monthly Salary</th>
   <th>Action</th>
   <th>Action</th>
                        <th></th>
                        <th></th>
  </tr>

  <c:forEach items="${payrollList}" var="payroll">
   <tr>
    <td><c:out value="${payroll.id}"/></td>
    <td><c:out value="${payroll.employee.name}"/></td>
    <td><c:out value="${payroll.gradeSalary}"/></td>
    <td><c:out value="${payroll.year}"/></td>
    <td><c:out value="${payroll.month}"/></td>
    <td><c:out value="${payroll.houseRentAllowance}"/></td>
    <td><c:out value="${payroll.festivalAllowance}"/></td>
    <td><c:out value="${payroll.medicalAllowance}"/></td>
    <td><c:out value="${payroll.transportAllowance}"/></td>
    <td><c:out value="${payroll.taxDeduction}"/></td>
    <td><c:out value="${payroll.otherDeduction}"/></td>
    <td><c:out value="${payroll.providentFund}"/></td>
    <td><c:out value="${payroll.penalty}"/></td>
    <td><c:out value="${payroll.monthlySalary}"/></td>

                                <td><b><a href="<c:url value='/payroll/edit/${payroll.id}' />">Edit</a></b></td>
                                <td><b><a href="<c:url value='/payroll/delete/${payroll.id}' />">Delete</a></b></td>
   </tr>
  </c:forEach>
 </table><br/>
</c:if>
<table style="border: none;">
 <tr>
  <td style="padding : none; border: none;"><h3><a href="/Sencillo/payroll/add">Add More Payroll</a></h3></td>
 </tr>
</table>
</body>
</html>
