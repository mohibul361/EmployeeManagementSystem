<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
<body>
 <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/department/add" />
	</c:when>
        
        <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/department/delete/${department.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="department" name="department" type="hidden" value="${department.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/department/edit/${department.id}" />
	</c:otherwise>
</c:choose>
   
 
<form:form action="${actionUrl}" modelAttribute="department" method="POST">
<table style="background-color:whitesmoke">
    
    <h1>
        Add/Edit Department
    </h1>  
       
       
       <tr>
           <td><form:label path="departmentName">Department Name:</form:label></td>
           <td><form:input path="departmentName" value="${department.departmentName}"/></td>
           <td><form:errors path="departmentName" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="departmentEmail">Department Email:</form:label></td>
                    <td><form:input path="departmentEmail" value="${department.departmentEmail}"/></td>
                    <td><form:errors path="departmentEmail" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="departmentPhoneNo">Department Phone Number:</form:label></td>
                    <td><form:input path="departmentPhoneNo" value="${department.departmentPhoneNo}"/></td>
                    <td><form:errors path="departmentPhoneNo" cssClass="error"></form:errors></td>
       </tr>
       
              <tr><td></td>
         <td colspan="2"><input type="submit" value="Add Department"/></td>     
        </tr>
        <tr>
            <td><a href="/Sencillo/departmentList.html" >List Of Department</a></td>
        </tr>
    
   </table> 
   </form:form>
 </body> 
 </head>