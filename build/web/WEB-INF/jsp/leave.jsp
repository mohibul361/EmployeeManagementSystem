<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script type="text/javascript">
    $(function() {
        $("#leaveType").change(function() {
//            alert(2);
            var id = $('option:selected', this).val();
             $.ajax({
                type: 'GET',
                url: "${pageContext.request.contextPath}/getLeaveTypeBalance/"+id,
                success:function(data){                   
                 alert(data);
                }
            });
         });
        
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
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/leave/add" />
	</c:when>
        
         <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/leave/delete/${leave.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="leave" name="leave" type="hidden" value="${leave.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/leave/edit/${leave.id}" />
	</c:otherwise>
</c:choose>
    
<form:form action="${actionUrl}" modelAttribute="leave" method="POST">
<table style="background-color:whitesmoke">
    
    <h1>
        Apply Leave
    </h1>  
        <tr>
           <td><form:label path="leaveType.id" >Leave Type:</form:label></td>
           <td>
            <form:select path="leaveType.id" id="leaveType">
			<option value="">--Select one--</option>
			<c:forEach items="${leaveTypeList}" var="leaveType">
				<option
					<c:if test="${leaveType.id eq leave.leaveType.id}">selected="selected"</c:if>
					value="${leaveType.id}">${leaveType.name}</option>
			</c:forEach>
		</form:select>
           </td>  
           <td id="result"></td>
       </tr>
       
       <tr>
           <td><form:label path="fromDate">From Date:</form:label></td>
           <td><form:input path="fromDate" value="${leave.fromDate}"/></td>
           <td><form:errors path="fromDate" cssClass="errors"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="toDate">To Date:</form:label></td>
                    <td><form:input path="toDate" value="${leave.toDate}"/></td>
                    <td><form:errors path="toDate" cssClass="errors"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="totalDay">Total Day:</form:label></td>
                    <td><form:input path="totalDay" value="${leave.totalDay}"/></td>
                    <td><form:errors path="totalDay" cssClass="errors"></form:errors></td>
       </tr>
              
       <tr>
           <td><form:label path="description">Description:</form:label></td>
           <td><form:textarea rows="2" cols="25"
                   path="description" value="${leave.description}"/></td>
           <td><form:errors path="description" cssClass="errors"></form:errors></td>
       </tr>
       
        <tr><td></td>
         <td colspan="2"><input type="submit" value="Apply Leave"/>
        </tr> 
   </table> 
   </form:form>
 </body> 
 </head>
 