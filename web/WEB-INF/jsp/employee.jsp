<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script type="text/javascript">
    $(function() {
		$('#dob').datepicker({
			dateFormat : 'dd/mm/yy'
		}).datepicker("setDate", new Date());
   });
</script>
<body>
    <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/employee/add" />
	</c:when>
        
         <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/employee/delete/${employee.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="employee" name="employee" type="hidden" value="${employee.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/employee/edit/${employee.id}" />
	</c:otherwise>
</c:choose>
 
<form:form action="${actionUrl}" modelAttribute="employee" method="POST">
<table style="background-color:whitesmoke">    
    <h1>
        Add/Edit Employee
    </h1>  
    <c:if test="${not empty ageLimitErrorMessage}">
        <h3 style="color: red">${ageLimitErrorMessage}</h3>
   </c:if>   
         <c:if test="${not empty emailErrorMessage}">
        <h3 style="color: red">${emailErrorMessage}</h3>
   </c:if>   
       <tr>
           <td><form:label path="name">Name:</form:label></td>
           <td><form:input path="name" value="${employee.name}"/></td>
           <td><form:errors path="name" cssClass="error"></form:errors></td>
       </tr>
        <tr>
           <td><form:label path="gender">Gender:</form:label></td>
           <td>
           <form:select path="gender">
               <option selected value="1">Male</option>
               <option value="1">Male</option>
               <option value="2">Female</option>
           </form:select>
           </td>
           
       </tr> 
       
       <tr>
           <td><form:label path="presentAddress">Present Address:</form:label></td>
                    <td><form:textarea  rows="2" cols="30" path="presentAddress" value="${employee.presentAddress}"/></td>
           <td><form:errors path="presentAddress" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="permanentAddress">Permanent Address:</form:label></td>
                    <td><form:textarea  rows="2" cols="30" path="permanentAddress" value="${employee.permanentAddress}"/></td>
           <td><form:errors path="permanentAddress" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="status">Status:</form:label></td>
                    <td><form:checkbox path="status" value="${employee.status}"/></td>
       </tr>
        <tr>
           <td><form:label path="nid">NID:</form:label></td>
                    <td><form:input path="nid" value="${employee.nid}"/></td>
                    <td><form:errors path="nid" cssClass="error"></form:errors></td>
       </tr>
       <tr>
           <td><form:label path="email">Email:</form:label></td>
                    <td><form:input path="email" value="${employee.email}"/></td>
                    <td><form:errors path="email" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           
       <tr>
           <td><form:label path="mobileNo">Mobile Number:</form:label></td>
                    <td><form:input path="mobileNo" value="${employee.mobileNo}"/></td>
                    <td><form:errors path="mobileNo" cssClass="error"></form:errors></td>
       </tr>

       <tr>
           <td><form:label path="dob">Date Of Birth:</form:label></td>
                    <td><form:input path="dob" value="${employee.dob}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="department.id">Department Name:</form:label></td>
           <td>
            <form:select path="department.id">
			<option value="">--Select one--</option>
			<c:forEach items="${departmentList}" var="department">
				<option
					<c:if test="${department.id eq employee.department.id}">selected="selected"</c:if>
					value="${department.id}">${department.departmentName}</option>
			</c:forEach>
		</form:select>
           </td>                     
       </tr>
       
       <tr>
           <td><form:label path="designation.id">Designation Name:</form:label></td>
          <td>     
            <form:select path="designation.id">
			<option value="">--Select one--</option>
			<c:forEach items="${designationList}" var="designation">
				<option
					<c:if test="${designation.id eq employee.designation.id}">selected="selected"</c:if>
					value="${designation.id}">${designation.designationName}</option>
			</c:forEach>
		</form:select>
            </td>    
       </tr>
       
       <tr>
           <td><form:label path="gradeType.id">Grade Name:</form:label></td>
          <td>     
            <form:select path="gradeType.id">
			<option value="">--Select one--</option>
			<c:forEach items="${gradeTypeList}" var="gradeType">
				<option
					<c:if test="${gradeType.id eq employee.gradeType.id}">selected="selected"</c:if>
					value="${gradeType.id}">${gradeType.name}</option>
			</c:forEach>
		</form:select>
            </td>    
       </tr>
       
       <tr><td></td>
         <td colspan="2"><input type="submit" value="Add Employee"/></td>
        </tr>
        <tr>
          <td><a href="/Sencillo/employeeList.html" >List Of Employee</a></td>
        </tr>
   </table> 
   </form:form>
 </body> 
 </head>