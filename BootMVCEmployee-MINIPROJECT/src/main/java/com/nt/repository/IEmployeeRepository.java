package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer>
{
	List<Employee> findByDeptno(int deptno);
	List<Employee> findByJob(String job);

}
