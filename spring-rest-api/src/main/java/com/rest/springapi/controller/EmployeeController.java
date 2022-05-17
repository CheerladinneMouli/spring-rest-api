package com.rest.springapi.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springapi.model.Employee;
//@Controller
@RestController //combination of @Controller + @ResponseBody
public class EmployeeController {
	
	//spring also providing the handfull methods when we are using http methods like get,post,put,delete
	//@RequestMapping(value = "/employees", method = RequestMethod.GET)
	//@ResponseBody
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppDetails() {
		return appName+" - "+appVersion;
	}
	
	@GetMapping("/employees")
	public String getEmployees () {      //handler method
		return "Displaying the list of employees";
	}
	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable long id) {
		return "fetching values";
		
	}
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		return "saving the employee details to the database"+employee;
	}
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		System.out.println("updating the employee details for the id "+id);
		return employee;
	}
	//localhost:8080/employees?id=15
	@DeleteMapping("/employees")
	public String deleteEmployee (@RequestParam("id") Long id) {
		return "deleting the employee details for the id "+id;
		
	}

}
