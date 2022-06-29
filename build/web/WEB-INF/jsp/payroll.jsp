<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script>
    $(function() {
//        alert(1);
        $("#employee").change(function() {
//            alert(2);
            var id = $('option:selected', this).val();
             $.ajax({
                type: 'GET',
                url: "${pageContext.request.contextPath}/getGradeSalary/"+id,
                success:function(data){
                 $("#gradeSalary").val(data);
                }
            });
         });
        
        $("#houseRentAllowance").keyup(function(){						
            var allowanceTotal = Number($("#gradeSalary").val())+Number($(this).val())+Number($("#festivalAllowance").val())+Number($("#transportAllowance").val())+Number($("#medicalAllowance").val());
            var deductionTotal = Number($("#totalDeduction").val());
            var monthlySalary = allowanceTotal-deductionTotal;  
            $("#totalAllowance").val(allowanceTotal);
            $("#monthlySalary").val(monthlySalary);
        });	
         $("#festivalAllowance").keyup(function(){						
            var allowanceTotal = Number($("#gradeSalary").val())+Number($(this).val())+Number($("#houseRentAllowance").val())+Number($("#transportAllowance").val())+Number($("#medicalAllowance").val());
            var deductionTotal = Number($("#totalDeduction").val());
            var monthlySalary = allowanceTotal-deductionTotal;  
             $("#totalAllowance").val(allowanceTotal);
            $("#monthlySalary").val(monthlySalary);
        });
        $("#transportAllowance").keyup(function(){						
            var allowanceTotal = Number($("#gradeSalary").val())+Number($(this).val())+Number($("#houseRentAllowance").val())+Number($("#festivalAllowance").val())+Number($("#medicalAllowance").val());
            var deductionTotal = Number($("#totalDeduction").val());
            var monthlySalary = allowanceTotal-deductionTotal;                    
             $("#totalAllowance").val(allowanceTotal);
            $("#monthlySalary").val(monthlySalary);
	}); 
         $("#medicalAllowance").keyup(function(){						
            var allowanceTotal = Number($("#gradeSalary").val())+Number($(this).val())+Number($("#houseRentAllowance").val())+Number($("#festivalAllowance").val())+Number($("#transportAllowance").val());
            var deductionTotal = Number($("#totalDeduction").val());
            var monthlySalary = allowanceTotal-deductionTotal;                    
             $("#totalAllowance").val(allowanceTotal);
            $("#monthlySalary").val(monthlySalary);
	});  

        $("#taxDeduction").keyup(function(){						
            var deductionTotal = Number($("#otherDeduction").val())+Number($(this).val())+Number($("#providentFund").val())+Number($("#penalty").val());
            var allowanceTotal = Number($("#totalAllowance").val());
            var monthlySalary = allowanceTotal-deductionTotal;  
            $("#totalDeduction").val(deductionTotal);
            $("#monthlySalary").val(monthlySalary);
        });
        
       
        $("#otherDeduction").keyup(function(){						
            var deductionTotal = Number($("#taxDeduction").val())+Number($(this).val())+Number($("#providentFund").val())+Number($("#penalty").val());
            var allowanceTotal = Number($("#totalAllowance").val());
            var monthlySalary = allowanceTotal-deductionTotal;  
            $("#totalDeduction").val(deductionTotal);
            $("#monthlySalary").val(monthlySalary);
        });
        $("#providentFund").keyup(function(){						
            var deductionTotal = Number($("#taxDeduction").val())+Number($(this).val())+Number($("#otherDeduction").val())+Number($("#penalty").val());
            var allowanceTotal = Number($("#totalAllowance").val());
            var monthlySalary = allowanceTotal-deductionTotal;  
            $("#totalDeduction").val(deductionTotal);
            $("#monthlySalary").val(monthlySalary);
        });
         $("#penalty").keyup(function(){						
            var deductionTotal = Number($("#taxDeduction").val())+Number($(this).val())+Number($("#otherDeduction").val())+Number($("#providentFund").val());
            var allowanceTotal = Number($("#totalAllowance").val());
            var monthlySalary = allowanceTotal-deductionTotal;  
            $("#totalDeduction").val(deductionTotal);
            $("#monthlySalary").val(monthlySalary);
        });
    });
</script>
<body>
 
    <c:choose>
	<c:when test="${actionType eq 'add'}">
		<c:set var="actionUrl" value="${pageContext.request.contextPath}/payroll/add" />
	</c:when>
        
         <c:when test="${actionType eq 'delete'}">
            <c:set var="actionUrl" value="${pageContext.request.contextPath}/payroll/delete/${payroll.id}" />
                <form id="${id}" action="${actionUrl}" method="POST">
                  <input id="payroll" name="payroll" type="hidden" value="${payroll.id}"/>
                  <input type="submit" value="delete" onClick="return confirm('sure?')"/>
                </form>
        </c:when>
        
	<c:otherwise>
		<c:set var="actionUrl"
			value="${pageContext.request.contextPath}/payroll/edit/${payroll.id}" />
	</c:otherwise>
</c:choose>
   
<form:form action="${actionUrl}" modelAttribute="payroll" method="POST">
<table style="background-color:whitesmoke">
    
    <h1>
        Add/Edit payroll
    </h1> 
    
       <tr>
           <td><form:label path="employee.id">Employee Name:</form:label></td>
           <td>
            <form:select path="employee.id" id ="employee">
			<option value="">--Select one--</option>
			<c:forEach items="${empList}" var="employee">
				<option
					<c:if test="${employee.id eq payroll.employee.id}">selected="selected"</c:if>
					value="${employee.id}">${employee.name}</option>
			</c:forEach>
		</form:select>
           </td>                     
       </tr>
       
       <tr>
           <td><form:label path="year">Year:</form:label></td>
           <td>
           <form:select path="year">
               <option selected value="1">2022</option>
               <option value="1">2020</option>
               <option value="2">2021</option>
               <option value="3">2022</option>
               <option value="4">2023</option>
               <option value="5">2024</option>
               <option value="6">2025</option>
               <option value="7">2026</option>
               <option value="8">2027</option>
               <option value="9">2028</option>
               <option value="10">2029</option>
               <option value="11">2030</option>
               <option value="12">2031</option>
           </form:select>
           </td>
           
       </tr> 
       
       <tr>
           <td><form:label path="month">Month:</form:label></td>
           <td>
           <form:select path="month">
               <option selected value="1">January</option>
               <option value="1">January</option>
               <option value="2">February</option>
               <option value="3">March</option>
               <option value="4">April</option>
               <option value="5">May</option>
               <option value="6">June</option>
               <option value="7">July</option>
               <option value="8">August</option>
               <option value="9">September</option>
               <option value="10">October</option>
               <option value="11">November</option>
               <option value="12">December</option>
           </form:select>
           </td>
           
       </tr>
       
       <tr>
           <td><form:label path="gradeSalary">Grade Salary:</form:label></td>
           <td><form:input  path="gradeSalary" value="${payroll.gradeSalary}"/></td>
           <td><form:errors path="gradeSalary" cssClass="errors"></form:errors></td>    
       </tr>
       
       <tr>
           <td><form:label path="houseRentAllowance">House Rent Allowance:</form:label></td>
           <td><form:input  path="houseRentAllowance" value="${payroll.houseRentAllowance}"/></td>
               <td><form:errors path="houseRentAllowance" cssClass="errors"></form:errors></td>
           
       </tr>
       
       <tr>
           <td><form:label path="festivalAllowance">Festival Allowance:</form:label></td>
           <td><form:input  path="festivalAllowance" value="${payroll.festivalAllowance}"/></td>
               <td><form:errors path="festivalAllowance" cssClass="errors"></form:errors></td>
           
       </tr>
       
       <tr>
           <td><form:label path="medicalAllowance">Medical Allowance:</form:label></td>
           <td><form:input  path="medicalAllowance" value="${payroll.medicalAllowance}"/></td>
               <td><form:errors  path="medicalAllowance" cssClass="errors"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="transportAllowance">Transport Allowance:</form:label></td>
           <td><form:input  path="transportAllowance" value="${payroll.transportAllowance}"/></td>
               <td><form:errors  path="transportAllowance" cssClass="errors"></form:errors></td>
           
       </tr>
       
        <tr>
           <td style="font-weight: bold"><form:label path="totalAllowance">Total Allowance</form:label></td>
           <td><form:input  path="totalAllowance" value="${payroll.totalAllowance}"/>
               <td><form:errors  path="totalAllowance" cssClass="errors"></form:errors></td>
           
       </tr>
       <tr>
           <td><form:label path="taxDeduction">Tax Deduction:</form:label></td>
           <td><form:input  path="taxDeduction" value="${payroll.taxDeduction}"/></td>
               <td><form:errors  path="taxDeduction" cssClass="errors"></form:errors></td>
           
       </tr>
       
       <tr>
           <td><form:label path="otherDeduction">Other Deduction</form:label></td>
           <td><form:input  path="otherDeduction" value="${payroll.otherDeduction}"/></td>
               <td><form:errors  path="otherDeduction" cssClass="errors"></form:errors></td>
           
       </tr>
       
       <tr>
           <td><form:label path="providentFund">Provident Fund</form:label></td>
           <td><form:input  path="providentFund" value="${payroll.providentFund}"/></td>
               <td><form:errors  path="providentFund" cssClass="errors"></form:errors></td>
       </tr>
       
       <tr>
           <td><form:label path="penalty">Penalty:</form:label></td>
           <td><form:input  path="penalty" value="${payroll.penalty}"/>
               <td><form:errors  path="penalty" cssClass="errors"></form:errors></td>
           
       </tr>
   <tr>
           <td style="font-weight: bold"><form:label path="totalDeduction">Total Deduction</form:label></td>
           <td><form:input  path="totalDeduction" value="${payroll.totalDeduction}"/>
               <td><form:errors  path="totalDeduction" cssClass="errors"></form:errors></td>
           
       </tr>
        <tr>
           <td><form:label path="monthlySalary">Monthly Salary</form:label></td>
           <td><form:input  path="monthlySalary" value="${payroll.monthlySalary}"/>
               <td><form:errors  path="monthlySalary" cssClass="errors"></form:errors></td>
           
       </tr>
       
       <tr><td></td>
         <td colspan="2"><input type="submit" value="Add Payroll"/></td>
        </tr>
        <tr>
            <td> <a href="/Sencillo/payrollList.html" >List Of Payroll</a></td>
        </tr>
    
   </table> 
   </form:form>
 </body> 
 </head>