<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
    
    <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/requisition/add" />
	</c:when>
        
        <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/requisition/delete/${requisition.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="requisition" name="requisition" type="hidden" value="${requisition.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/requisition/edit/${requisition.id}" />
	</c:otherwise>
</c:choose>
   
 
<form:form action="${actionUrl}" modelAttribute="requisition" method="POST">
<table style="background-color:whitesmoke">
    
    <h1>
        Apply Requisition
    </h1>  
       
       <tr>
           <td><form:label path="itemName">Item Name:</form:label></td>
           <td><form:input path="itemName" value="${requisition.itemName}"/></td>
           <td><form:errors path="itemName" cssClass="errors"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="quantity">Quantity:</form:label></td>
                    <td><form:input path="quantity" value="${requisition.quantity}"/></td>
                    <td><form:errors path="quantity" cssClass="errors"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="unit">Unit:</form:label></td>
                    <td><form:input path="unit" value="${requisition.unit}"/></td>
                    <td><form:errors path="unit" cssClass="errors"></form:errors></td>
                    
       </tr>
       
       <tr>
           <td><form:label path="description">Description:</form:label></td>
           <td><form:textarea rows="2" cols="25"
                   path="description" value="${requisition.description}"/></td>
           <td><form:errors path="description" cssClass="errors"></form:errors></td>
           
       </tr>
       
       <tr>
           <td><form:label path="amount">Amount:</form:label></td>
                    <td><form:input path="amount" value="${requisition.amount}"/></td>
                    <td><form:errors path="amount" cssClass="errors"></form:errors></td>
       </tr>
       
              <tr><td></td>
         <td colspan="2"><input type="submit" value="Apply Requisition"/>
        </tr>
   </table> 
   </form:form>
 </body> 
 </head>