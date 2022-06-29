<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
 <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/annualLeave/add" />
	</c:when>
        
        <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/annualLeave/delete/${annualLeave.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="annualLeave" name="annualLeave" type="hidden" value="${annualLeave.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/annualLeave/edit/${annualLeave.id}" />
	</c:otherwise>
</c:choose>
   
 
<form:form action="${actionUrl}" modelAttribute="annualLeave" method="POST">
<table style="background-color:whitesmoke">
    
    <h1>
        Add/Edit Annual Leave
    </h1>  
       
     <td><form:label path="employee.id">Employee Name:</form:label></td>
         <td>
            <form:select path="employee.id">
			<option value="">--Select one--</option>
			<c:forEach items="${empList}" var="employee">
				<option
					<c:if test="${employee.id eq annualLeave.employee.id}">selected="selected"</c:if>
					value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</form:select>
           </td>                     
       </tr>
       
        <tr>
           <td><form:label path="leaveType.id">Leave Type:</form:label></td>
           <td>
            <form:select path="leaveType.id">
			<option value="">--Select one--</option>
			<c:forEach items="${leaveTypeList}" var="leaveType">
				<option
					<c:if test="${leaveType.id eq annualLeave.leaveType.id}">selected="selected"</c:if>
					value="${leaveType.id}">${leaveType.name}</option>
			</c:forEach>
		</form:select>
           </td>                     
       </tr>
       
        <tr>
           <td><form:label path="year">Year:</form:label></td>
           <td>
           <form:select path="year">
               <option selected value="1">2022</option>
               <option value="1">2020</option>
               <option value="2">2021</option>
               <option value="3">2022</option>
               <option value="4">2023</option>
               <option value="5">2024</option>
               <option value="6">2025</option>
               <option value="7">2026</option>
               <option value="8">2027</option>
               <option value="9">2028</option>
               <option value="10">2029</option>
               <option value="11">2030</option>
               <option value="12">2031</option>
           </form:select>
           </td>
           
       </tr> 
       
       <tr>
           <td><form:label path="leaveDaysAllowed">Maximum Days Allowed:</form:label></td>
                    <td><form:input path="leaveDaysAllowed" value="${annualLeave.leaveDaysAllowed}"/></td>
       </tr>
       
              <tr><td></td>
         <td colspan="2"><input type="submit" value="Add AnnualLeave"/></td>
         </tr>
         <tr>
         <td><a href="/Sencillo/annualLeaveList.html" >List Of Annual Leave</a></td>
        </tr>
    
   </table> 
   </form:form>
 </body> 
 </head>
