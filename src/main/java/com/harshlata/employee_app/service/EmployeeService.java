package com.harshlata.employee_app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.harshlata.data.models.Employee;
import com.harshlata.data.payload.request.EmployeeRequest;
import com.harshlata.data.payload.response.MessageResponse;

@Component
public interface EmployeeService {

	MessageResponse createEmployee(EmployeeRequest employeeRequest);

	Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest) throws Exception;

	void deleteEmployee(Integer employeeId) throws Exception;

	Employee getASingleEmployee(Integer employeeId) throws Exception;

	List<Employee> getAllEmployee();

}
