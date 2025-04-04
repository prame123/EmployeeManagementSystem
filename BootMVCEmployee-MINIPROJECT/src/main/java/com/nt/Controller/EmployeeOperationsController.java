package com.nt.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empservice;
	
	@GetMapping("/")
public String showHome()
{
		return "Home";
}
	@GetMapping("/emp_add")
	public String showFormforSaveEmployee(@ModelAttribute("emp")Employee emp)
	{
		//return logical view name
		return"register_employee";
	}
	@PostMapping("/emp_add")
	public String savaEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map)
	{
		//use service
		String msg=empservice.registerEmployee(emp);
		//retrive update list of employees
		Iterable<Employee> itEmps=empservice.getAllEmployee();
		//keep the result in ModelAttribute
		map.put("resultMsg",msg);
		map.put("emplist", itEmps);
		//return Logical View Name
		return "show-employee-report";
	}
	
	
	/*this method have not apply pagination its generate narmal report,so we can to pagination report to show all employees based on size
	 * @GetMapping("/report") public String
	 * showEmployeeReport(Map<String,Object>map) { //use Service Iterable<Employee>
	 * itEmps=empservice.getAllEmployee(); //put result in modern Attribute
	 * map.put("emplist", itEmps); //return Logical view name return
	 * "show-employee-report"; }
	 */
	

	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@RequestParam("no") int no,@ModelAttribute("emp")Employee emp)
	{
		//use service
		Employee emp1=empservice.getEmployeeByeno(no);
		//copy data
		BeanUtils.copyProperties(emp1, emp);
		//return Logical View name
		return "update_employee";
	}
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp)
	{
		//use service
		String msg=empservice.updateEmployee(emp);
		//add the result message as flash Attribute
		attrs.addFlashAttribute("resultMsg",msg);
		//redirect the redirect
		return "redirect:/report";
	}
	
	
	@GetMapping("/emp_delete")
	public String deleteEmployee(RedirectAttributes attrs,@RequestParam int no) 
	{
		//use service
		String msg=empservice.deleteEmployeeById(no);
		//keep the result in flashAttribute
		attrs.addFlashAttribute("resultMsg",msg);
//redirect the request
		return "redirect:/report";
		
	}
	
	
	@GetMapping("/employees_by_dept")
	public String getEmployeesByDept(@RequestParam("deptno") int deptno, Map<String, Object> map) {
	    List<Employee> deptEmployees = empservice.getEmployeesByDeptNo(deptno);
	    map.put("emplist", deptEmployees);
	    return "show-employee-report"; 
	}
	
	@GetMapping("/employees_by_jobname")
	public String getEmployeesByJob(@RequestParam("job")String job,Map<String,Object>map)
	{
		List<Employee> deptjobs=empservice.getEmployeeByJob(job);
		map.put("emplist", deptjobs);
		return "show-employee-report";
	}
	@GetMapping("/report")
	public String showReportRedirect() {
	    return "redirect:/paged_report?page=0";  //load page 0 first
	}


	@GetMapping("/paged_report")
	public String showReportWithPagination(@RequestParam(name = "page", defaultValue = "0") int page, Map<String, Object> map) {
	    int pageSize = 5;
	    Page<Employee> pageResult = empservice.getEmployeesWithPagination(page, pageSize);

	    map.put("emplist", pageResult.getContent());
	    map.put("currentPage", page);
	    map.put("totalPages", pageResult.getTotalPages());

	    return "show-employee-report";
	}

	    }
	




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
