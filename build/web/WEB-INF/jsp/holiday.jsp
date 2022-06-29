<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script type="text/javascript">
    $(function() {
		$('#fromDate').datepicker({
			dateFormat : 'dd/mm/yy'
		}).datepicker("setDate", new Date());
                $('#toDate').datepicker({
			dateFormat : 'dd/mm/yy'
		}).datepicker("setDate", new Date());
   });
</script>
<body>
 <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/holiday/add" />
	</c:when>
        
        <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/holiday/delete/${holiday.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="holiday" name="holiday" type="hidden" value="${holiday.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/holiday/edit/${holiday.id}" />
	</c:otherwise>
</c:choose>
   
 
<form:form action="${actionUrl}" modelAttribute="holiday" method="POST">
<table style="background-color: whitesmoke">
    
    <h1>
        Add/Edit Holiday
    </h1>  
       
       
       <tr>
           <td><form:label path="holidayName">Holiday Name:</form:label></td>
           <td><form:input path="holidayName" value="${holiday.holidayName}"/></td>
           <td><form:errors path="holidayName" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="fromDate">From Date:</form:label></td>
                    <td><form:input path="fromDate" value="${holiday.fromDate}"/></td>
                    <td><form:errors path="fromDate" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="toDate">To Date:</form:label></td>
                    <td><form:input path="toDate" value="${holiday.toDate}"/></td>
                    <td><form:errors path="toDate" cssClass="error"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="description">Description:</form:label></td>
           <td><form:textarea rows="2" cols="25"
                   path="description" value="${holiday.description}"/></td>
           <td><form:errors path="description" cssClass="errors"></form:errors></td>
       </tr>
       
              <tr><td></td>
         <td colspan="2"><input type="submit" value="Add Holiday"/></td></tr>
             <tr>
           <td>  <a href="/Sencillo/holidayList.html" >List Of Holiday</a></td>
        </tr>
    
   </table> 
   </form:form>
 </body> 
 </head>