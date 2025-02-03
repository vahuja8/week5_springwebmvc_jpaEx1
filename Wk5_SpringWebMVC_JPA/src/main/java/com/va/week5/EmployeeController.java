package com.va.week5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	// support dependency injection!!. and remote
	//invocation of methods.. 
	
@RequestMapping ("/index")
public String home()
{
	return "index";
}

@PostMapping("/add")
public @ResponseBody String add
      (
	  @RequestParam("empId") int empId,
      @RequestParam("empName") String empName,
      @RequestParam("jobTitle") String jobTitle,
      @RequestParam("salary") double salary,
      @RequestParam("deptNo") int deptNo
      )
{
Employee employee=new Employee(empId,empName,jobTitle,salary,deptNo);
empRepo.save(employee);
return "An employee info added";
}
	
}
