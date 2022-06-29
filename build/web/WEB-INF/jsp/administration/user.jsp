<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
 
 
<form:form action="/Sencillo/user/" modelAttribute="user" method="POST">
<table>
    
    <h1>
        Create User
    </h1>  
       
       
       <tr>
           <td><form:label path="userName">User Name:</form:label></td>
           <td><form:input path="userName" value="${user.userName}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="active">Active:</form:label></td>
                    <td><form:checkbox path="active" value="${user.active}"/></td>
       </tr>
       
       
       <tr>
           <td><form:label path="password">Password:</form:label></td>
                    <td><form:password path="password" value="${user.password}"/></td>
       </tr>
      
       
       <tr>
           <td><form:label path="employee.id">Employee Name:</form:label></td>
           <td>
            <form:select path="employee.id">
			<option value="">--Select one--</option>
			<c:forEach items="${empList}" var="employee">
				<option
					<c:if test="${employee.id eq user.employee.id}">selected="selected"</c:if>
					value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</form:select>
           </td>                     
       </tr>
       
       <tr>
           <td><form:label path="role.id">Employee Role:</form:label></td>
           <td>
            <form:select path="role.id">
			<option value="">--Select one--</option>
			<c:forEach items="${roleList}" var="role">
				<option
					<c:if test="${role.id eq user.role.id}">selected="selected"</c:if>
					value="${role.id}">${role.roleName}</option>
			</c:forEach>
		</form:select>
           </td>                     
       </tr>
       
              <tr><td></td>
         <td colspan="2"><input type="submit" value="Save"/>
        </tr>
    
   </table> 
   </form:form>
    <table id="global-table">
	<thead>
		<tr>
                        <th>ID</th>
			<th>User Name</th>
			<th>Active</th>
			<th>Employee Name</th>
			<th>Role Name</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${userList}">
			<tr>
                                <td><c:out value="${user.id}"></c:out></td>
                                <td><c:out value="${user.userName}"></c:out></td>
				<td><c:out value="${user.active}"></c:out></td>
				<td><c:out value="${user.employee.name}"></c:out></td>
                                <td><c:out value="${user.role.roleName}"></c:out></td>
				<td><a href="${contextPath}/user/${user.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</table>
<div id="result"></div>
<script type="text/javascript">
	$(function() {
		$("#nameInput").focus();
	});
</script>
 </body> 
 </head>