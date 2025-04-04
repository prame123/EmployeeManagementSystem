package com.nt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;
@Service
public class ServiceImgEmployee implements IEmployeeMgmtService
{
	@Autowired
private IEmployeeRepository emprepo;
	@Override
	public String registerEmployee(Employee emp) {
		
		return "employee is saved with id value"+emprepo.save(emp).getEmpno();
	}

	@Override
	public Iterable<Employee> getAllEmployee() {
	
		return emprepo.findAll();
	}

	@Override
	public Employee getEmployeeByeno(int eno) {
		Employee emp=emprepo.findById(eno).orElseThrow(()->new IllegalArgumentException());
		return emp;
	}

	@Override
	public String deleteEmployeeById(int eno) {
		emprepo.deleteById(eno);
		return eno+"employee id Employee is deleted";
	}

	@Override
	public String updateEmployee(Employee emp) {
	
		return "Employee is Updated with having id value::"+emprepo.save(emp).getEmpno();
	}

	 @Override
	    public List<Employee> getEmployeesByDeptNo(int deptno) {
	        return emprepo.findByDeptno(deptno);
	    }
	 
	 @Override
	 public List<Employee> getEmployeeByJob(String job)
	 {
		 return emprepo.findByJob(job);
		 
	 }
	 public Page<Employee> getEmployeesWithPagination(int pageNo, int pageSize) {
		    Pageable pageable = PageRequest.of(pageNo, pageSize);
		    return emprepo.findAll(pageable);
		}


}
