<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
 
    <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/salary/add" />
	</c:when>
        
         <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/salary/delete/${salary.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="salary" name="salary" type="hidden" value="${salary.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/salary/edit/${salary.id}" />
	</c:otherwise>
</c:choose>
    
<form:form action="${actionUrl}" modelAttribute="salary" method="POST">
<table style="background-color:whitesmoke">
    
    <h1>
        Add/Edit Salary
    </h1>  
            
     <tr>
           <td><form:label path="employee.id">Employee Name:</form:label></td>
           <td>
            <form:select path="employee.id">
			<option value="">--Select one--</option>
			<c:forEach items="${empList}" var="employee">
				<option
					<c:if test="${employee.id eq salary.employee.id}">selected="selected"</c:if>
					value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</form:select>
           </td>                     
       </tr>
        
       <tr>
           <td><form:label path="monthlySalary">Monthly Salary:</form:label></td>
                    <td><form:input path="monthlySalary" value="${salary.monthlySalary}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="salaryEffectiveDate">Salary Effective Date:</form:label></td>
                    <td><form:input path="salaryEffectiveDate" value="${salary.salaryEffectiveDate}"/></td>
       </tr>
       
        <tr>
           <td><form:label path="bankAccountNumber">Bank Account Number:</form:label></td>
                    <td><form:input path="bankAccountNumber" value="${salary.bankAccountNumber}"/></td>
       </tr>
       
        <tr>
           <td><form:label path="bankName">Bank Name:</form:label></td>
                    <td><form:input path="bankName" value="${salary.bankName}"/></td>
       </tr>
       
        <tr>
           <td><form:label path="bankBranchName">Bank Branch Name:</form:label></td>
                    <td><form:input path="bankBranchName" value="${salary.bankBranchName}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="taxIdentificationNumber">Tax Identification Number:</form:label></td>
                    <td><form:input path="taxIdentificationNumber" value="${salary.taxIdentificationNumber}"/></td>
       </tr>
       
              <tr><td></td>
         <td colspan="2"><input type="submit" value="Add Salary"/>
        </tr>
        <tr>
            <td><a href="/Sencillo/salaryList.html" >List Of Salary</a></td>
        </tr>
       
   </table> 
   </form:form>
 </body> 
 </head>