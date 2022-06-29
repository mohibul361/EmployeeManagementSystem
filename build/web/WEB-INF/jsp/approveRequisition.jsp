<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body> 
   
<c:set var="actionUrl" value="${pageContext.request.contextPath}/approveRequisition/${requisition.id}" />    
<form:form action="${actionUrl}" modelAttribute="requisition" method="POST">
<table align="left" width="100%" style="border:1px solid black;
                                        background-color:whitesmoke">
    
    <h1>
       Requisition Info
    </h1>  
        
    <tr colspan="2">
        <td>Employee Name</td>
         <td>${requisition.employee.id}</td>
         
     </tr>   
     <tr>
         <td>Item Name</td>
         <td>${requisition.itemName}</td>  
         <td>Quantity</td>
         <td>${requisition.quantity}</td>
     </tr> 
     <tr> 
         <td>Unit</td>
         <td>${requisition.unit}</td>
         <td>Description</td>
         <td>${requisition.description}</td>
     </tr> 
     <tr> 
         <td>Amount</td>
         <td>${requisition.amount}</td>
         <td>Apply Date</td>
         <td>${requisition.applyDate}</td>
     </tr>
     <tr>
         <td>Status</td>
         <td>${requisition.status}</td>  
     </tr> 
     <tr>
         <td ><input type="submit" name="approve" value="Approve"/> </td>
         <td ><input type="submit" name="reject" value="Reject"/> &nbsp; &nbsp; &nbsp;<b><a href="/Sencillo/pendingRequisitionList.html" >List Of Pending Requisition</a></b></td>
     </tr>
   
   </table> 
   </form:form>
 </body> 
 </head>
 