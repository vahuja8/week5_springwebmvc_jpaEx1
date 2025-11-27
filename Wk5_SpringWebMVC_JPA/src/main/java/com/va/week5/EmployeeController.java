package com.va.week5;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	ObjectMapper objectMapper = new ObjectMapper();
Employee employee=new Employee(empId,empName,jobTitle,salary,deptNo);  // initialize the values of contructor.
File f1 = new  File("target/employee.json");

try {
	objectMapper.writeValue(f1, employee);
} catch (StreamWriteException e) {
	
	System.out.println(e.getLocalizedMessage());
	System.out.println(e.getMessage());
	System.out.println(e.getCause());
	System.out.println(e.hashCode());  //..
	
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (DatabindException e) {
	System.out.println(e.getLocalizedMessage());
	System.out.println(e.getMessage());
	System.out.println(e.getCause());
	System.out.println(e.hashCode());  //..
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	System.out.println(e.getLocalizedMessage());
	System.out.println(e.getMessage());
	System.out.println(e.getCause());
	System.out.println(e.hashCode());  //..
	// TODO Auto-generated catch block
	e.printStackTrace();
}

 /*
  * catch -- state , IO, getcause/getstate, exceptionid
  */

/*
 * ObjectMapper objectMapper = new ObjectMapper();
Car car = new Car("yellow", "renault");
objectMapper.writeValue(new File("target/car.json"), car);

 */

/*
 * For other project --- use this idea.. 
 *  Car car = objectMapper.readValue(new File("src/test/resources/json_car.json"), Car.class);

 * 
 */




empRepo.save(employee);
// this will create an insert query to save the entity with specific attributes 
// that it got from the client!. 
// insert into employee table values(......);

return "An employee info added";
}
	
}
