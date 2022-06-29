<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
 
    <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/designation/add" />
	</c:when>
        <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/designation/delete/${designation.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="designation" name="designation" type="hidden" value="${designation.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/designation/edit/${designation.id}" />
	</c:otherwise>
</c:choose>
    
<form:form action="${actionUrl}" modelAttribute="designation" method="POST">
<table style="background-color:whitesmoke">
    
    <h1>
        Add/Edit Designation
    </h1>  
       <tr>
           <td><form:label path="designationName">Designation Name:</form:label></td>
           <td><form:input path="designationName" value="${designation.designationName}"/></td>
           <td><form:errors path="designationName" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="employee.id">Employee Name:</form:label></td>
           <td>
            <form:select path="employee.id">
			<option value="">--Select one--</option>
			<c:forEach items="${empList}" var="employee">
				<option
					<c:if test="${employee.id eq designation.employee.id}">selected="selected"</c:if>
					value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</form:select>
           </td>                     
       </tr>
       
              <tr><td></td>
         <td colspan="2"><input type="submit" value="Add Designation"/>&nbsp; &nbsp; &nbsp;<b><a href="/Sencillo/designationList.html" >List Of Designation</a></b></td>
        </tr>
       
   </table> 
   </form:form>
 </body> 
 </head>