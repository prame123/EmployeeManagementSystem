package com.nt.service;



import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
public String registerEmployee(Employee emp);
public Iterable<Employee> getAllEmployee();	
public Employee getEmployeeByeno(int eno);
public String deleteEmployeeById(int eno);
public String updateEmployee(Employee emp);
public List<Employee> getEmployeesByDeptNo(int deptno);
public List<Employee> getEmployeeByJob(String job);
public Page<Employee> getEmployeesWithPagination(int pageNo, int pageSize);
}
