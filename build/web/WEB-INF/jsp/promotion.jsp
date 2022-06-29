<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
    
    <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/promotion/add" />
	</c:when>
        
        <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/promotion/delete/${promotion.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="promotion" name="promotion" type="hidden" value="${promotion.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/promotion/edit/${promotion.id}" />
	</c:otherwise>
</c:choose>
   
 
<form:form action="${actionUrl}" modelAttribute="promotion" method="POST">
<table>
    
    <h1>
        Apply Promotion
    </h1>  
       
        <tr>
           <td><form:label path="designation.id">Apply Designation Name:</form:label></td>
          <td>     
            <form:select path="designation.id">
			<option value="">--Select one--</option>
			<c:forEach items="${designationList}" var="designation">
				<option
					<c:if test="${designation.id eq promotion.designation.id}">selected="selected"</c:if>
					value="${designation.id}">${designation.designationName}</option>
			</c:forEach>
		</form:select>
            </td>    
       </tr>
        <tr><td></td>
         <td colspan="2"><input type="submit" value="Apply Promotion"/>
        </tr>
    
   </table> 
   </form:form>
 </body> 
 </head>