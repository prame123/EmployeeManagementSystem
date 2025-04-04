<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:red;text-align:center">updateEmployee</h1>
<frm:form modelAttribute="emp">
<table align="center" bgcolor="yellow">
<tr>
<td>EmployeeNumber::</td>
<td><frm:input path="empno" readonly="true"/></td>
</tr>
<tr>
<td>EmployeeName::</td>
<td><frm:input path="ename" /></td>
</tr>
<tr>
<td>Employee Designation::</td>
<td><frm:input path="job"/></td>
</tr>
<tr>
<td> Employee salary::</td>
<td><frm:input path="sal"/></td>
</tr>
<tr>
<td>Employee Employee Department NO::</td>
<td><frm:input path="deptno"/></td>
</tr>
<tr>
<td><input type="submit" value="Update Employee">
<td><input type="reset" value="cancel">
</tr>


</table>
</frm:form>