<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
    <c:when test="${!empty emplist}">
        <h1 style="color:red;text-align:center">Employee Report</h1>
        <table border="1" align="center" bgcolor="cyan">
            <tr style="color:red">
                <th>Emp No</th>
                <th>Name</th>
                <th>Job</th>
                <th>Salary</th>
                <th>Dept No</th>
                <th>Operations</th>
            </tr>
            <c:forEach var="emp" items="${emplist}">
                <tr>
                    <td>${emp.empno}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.job}</td>
                    <td>${emp.sal}</td>
                    <td>${emp.deptno}</td>
                    <td>
                        <a href="emp_edit?no=${emp.empno}">
                            <img src="images/edit.png" width="30px" height="30px"> Edit
                        </a>
                        &nbsp;&nbsp;
                        <a href="emp_delete?no=${emp.empno}" onclick="return confirm('Do you want to delete this employee?')">
                            <img src="images/delete.png" width="30px" height="30px"> Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1 style="color:pink;text-align:center">EMPLOYEE DATA NOT FOUND HERE</h1>
    </c:otherwise>
</c:choose>

<center>
    <h2 style="color:green;">${resultMsg}</h2>
</center>

<!-- Adding Employees -->
<center>
    <a href="emp_add">
        <img src="images/add.png" width="30px" height="30px"> ADD EMPLOYEE
    </a>
</center>


<!-- Home Page -->
<center>
    <a href="./">
        <img src="images/Home.png" width="30px" height="30px"> HOME
    </a>
</center>

<!-- Fetch the Employees based on department number -->

<center>
<div style="text-align:center;">
    <h3 style="color:blue;">Filter by Department</h3>
    <a href="employees_by_dept?deptno=10">Department 10</a> 
    <a href="employees_by_dept?deptno=20">Department 20</a> 
    <a href="employees_by_dept?deptno=30">Department 30</a> 
   <a href="report">Show All</a>


</div>
</center>


<!-- fetch the employees based on job -->
<center>
    <h3 style="color:blue;">Filter by Department Name</h3>
    <a href="employees_by_jobname?job=java developer">Java developer</a> 
    <a href="employees_by_jobname?job=SALESMAN">salesman</a> 
    <a href="employees_by_jobname?job=CLERK">clerk</a> 
    <a href="report">Show All</a>


</center>


<!-- display Employees using pagination -->

<c:if test="${totalPages > 1}">
    <div style="text-align: center; margin-top: 20px;">
        <c:if test="${currentPage > 0}">
            <a href="paged_report?page=${currentPage - 1}">Previous</a>
        </c:if>

        <c:forEach begin="0" end="${totalPages - 1}" var="i">
            <c:choose>
                <c:when test="${i == currentPage}">
                    <strong>[${i + 1}]</strong>
                </c:when>
                <c:otherwise>
                    <a href="paged_report?page=${i}">${i + 1}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage < totalPages - 1}">
            <a href="paged_report?page=${currentPage + 1}">Next</a>
        </c:if>
    </div>
</c:if>


