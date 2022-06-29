<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>All Leave</title>
        <style>

            /*            table, th, td {
                            border: 1px solid black;
                            border-collapse: collapse;
                            background-color: whitesmoke;
                        }*/
            #data-table, th, td{
                border: 1px solid black;
                border-collapse: collapse;
                background-color: whitesmoke;
            }
            th, td {
                padding: 5px;
                text-align: left;
            }
        </style>
        <script type="text/javascript">
            $(function () {
                $('#fromDate').datepicker({
                    dateFormat: 'dd/mm/yy'
                }).datepicker("setDate", new Date());
            });
            $(function () {
                $('#toDate').datepicker({
                    dateFormat: 'dd/mm/yy'
                }).datepicker("setDate", new Date());
            });
        </script>
    </head>
    <body>
        <h1>Leave Report</h1>
        <form:form action="/Sencillo/leaveReport" modelAttribute="leaveReportForm" method="POST">
            <table border="0" cellspacing="0" cellpadding="0">
                <tr>

                    <td><form:label path="fromDate">From Date:</form:label></td>
                    <td><form:input path="fromDate" value="${leaveReportForm.fromDate}"/></td> 

                    <td><form:label path="toDate">To Date:</form:label></td>
                    <td><form:input path="toDate" value="${leaveReportForm.toDate}"/></td>
                    <td colspan="2"><input type="submit" value="Search"/>
                </tr>  
        </table>
    </form:form>

        <table id="data-table" align="left" width="100%">
        <tr>
            <th>ID</th>
            <th>Employee Name</th>
            <th>Leave Type</th>
            <th>From Date</th>
            <th>To Date</th>
            <th>Total Day</th>
            <th>Date Of Application</th>
            <th>Description</th>
            <th>Status</th>

        </tr>

        <c:forEach items="${leaveList}" var="leave">
            <tr>
                <td><c:out value="${leave.id}"/></td>
                <td><c:out value="${leave.employee.name}"/></td>
                <td><c:out value="${leave.leaveType.name}"/></td>
                <td><c:out value="${leave.toDate}"/></td>
                <td><c:out value="${leave.fromDate}"/></td>
                <td><c:out value="${leave.totalDay}"/></td>
                <td><c:out value="${leave.dateOfApplication}"/></td>
                <td><c:out value="${leave.description}"/></td>
                <td><c:out value="${leave.status}"/></td>
            </tr>
        </c:forEach>
    </table><br/>
</body>
</html>