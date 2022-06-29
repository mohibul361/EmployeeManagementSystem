<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
 <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/leaveType/add" />
	</c:when>
        
        <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/leaveType/delete/${leaveType.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="leaveType" name="leaveType" type="hidden" value="${leaveType.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/leaveType/edit/${leaveType.id}" />
	</c:otherwise>
</c:choose>
   
 
<form:form action="${actionUrl}" modelAttribute="leaveType" method="POST">
<table style="background-color:whitesmoke">
    
    <h1>
        Add/Edit Leave Type
    </h1>  
       
       
       <tr>
           <td><form:label path="name">Name:</form:label></td>
           <td><form:input path="name" value="${leaveType.name}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="description">Description:</form:label></td>
           <td><form:textarea  rows="2" cols="30" path="description" value="${leaveType.description}"/></td>
           <td><form:errors path="description" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="numberDaysAllowed">Maximum Days:</form:label></td>
                    <td><form:input path="numberDaysAllowed" value="${leaveType.numberDaysAllowed}"/></td>
       </tr>
       
              <tr><td></td>
         <td colspan="2"><input type="submit" value="leaveType"/>
        </tr>
        <tr>
            <td><a href="/Sencillo/leaveTypeList.html" >List Of Leave Type</a></td>
            </tr>
    
   </table> 
   </form:form>
 </body> 
 </head>
