package com.harshlata.employee_app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harshlata.data.models.Employee;
import com.harshlata.data.payload.request.EmployeeRequest;
import com.harshlata.data.payload.response.MessageResponse;
import com.harshlata.data.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
   EmployeeRepository employeeRepository;
	 
	@Override
	public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
		
		Employee newEmployee = new Employee();
		newEmployee.setFirstName(employeeRequest.getFirstName());
		newEmployee.setLastName(employeeRequest.getLastName());
		newEmployee.setEmail(employeeRequest.getEmail());
		newEmployee.setDepartment(employeeRequest.getDepartment());
		newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
		newEmployee.setSalary(employeeRequest.getSalary());
		return new MessageResponse("New Employee Created Successfully");
	}

	@Override
	public Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest) throws Exception {
		Optional<Employee> employee =  employeeRepository.findById(employeeId);
		if(employee.isEmpty())
		{
			throw new Exception("unable to fetch employee id against :"+employeeId);
		}
		else
		{
			employee.get().setFirstName(employeeRequest.getFirstName());
			employee.get().setLastName(employeeRequest.getLastName());
			employee.get().setEmail(employeeRequest.getEmail());
			employee.get().setDepartment(employeeRequest.getDepartment());
			employee.get().setPhoneNumber(employeeRequest.getPhoneNumber());
			employee.get().setSalary(employeeRequest.getSalary());
			employeeRepository.save(employee.get());
		}
		return employee;
	}

	@Override
	public void deleteEmployee(Integer employeeId) throws Exception {
		employeeRepository.findById(employeeId);
	}

	@Override
	public Employee getASingleEmployee(Integer employeeId) throws Exception {
		return employeeRepository.findById(employeeId).orElseThrow(() ->  new Exception(" unable to fetch employee against :"+employeeId));
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
