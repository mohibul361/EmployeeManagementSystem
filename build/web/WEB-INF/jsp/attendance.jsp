    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
 
    <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/attendance/add" />
	</c:when>
        
         <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/attendance/delete/${attendance.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="attendance" name="attendance" type="hidden" value="${attendance.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/attendance/edit/${attendance.id}" />
	</c:otherwise>
</c:choose>
   
 
<form:form action="${actionUrl}" modelAttribute="attendance" method="POST">
<table>
    
    <h1>
        Edit Attendance
    </h1>  
       
       
       <tr>
           <td><form:label path="date">Date:</form:label></td>
           <td><form:input path="date" value="${attendance.date}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="status">Attendance Status:</form:label></td>
                    <td><form:checkbox path="status" value="${attendance.status}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="employee.id">Employee Name:</form:label></td>
           <td>
            <form:select path="employee.id">
			<option value="">--Select one--</option>
			<c:forEach items="${empList}" var="employee">
				<option
					<c:if test="${employee.id eq attendance.employee.id}">selected="selected"</c:if>
					value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</form:select>
           </td>                     
       </tr>
           
              <tr><td></td>
         <td colspan="2"><input type="submit" value="Add Attendance"/>&nbsp; &nbsp; &nbsp;<b><a href="/Sencillo/attendanceList.html" >List Of Attendance</a></b></td>
        </tr>
    
   </table> 
   </form:form>
 </body> 
 </head>