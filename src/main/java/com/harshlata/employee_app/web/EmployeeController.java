package com.harshlata.employee_app.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.harshlata.data.models.Employee;
import com.harshlata.data.payload.request.EmployeeRequest;
import com.harshlata.data.payload.response.MessageResponse;
import com.harshlata.employee_app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value =  "/all" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> employees = employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeByIdEmployee(@PathVariable("id") Integer id) throws Exception
	{
	  Employee employee = employeeService.getASingleEmployee(id);
	  return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest)
	{
		MessageResponse messageResponse =  employeeService.createEmployee(employeeRequest);
		return new ResponseEntity<MessageResponse>(messageResponse, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id , @RequestBody EmployeeRequest employeeRequest) throws Exception
	{
	  Optional <Employee> employee  =   employeeService.updateEmployee(id, employeeRequest);	
	  return new ResponseEntity<Employee>(employee.get() , HttpStatus.OK);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) throws Exception
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value= "/test")
	public void test(@RequestParam("test") Boolean test)
	{
		System.out.println("tests....");
	}
}
