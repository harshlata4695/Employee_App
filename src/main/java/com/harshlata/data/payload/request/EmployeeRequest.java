package com.harshlata.data.payload.request;

import com.harshlata.data.models.Department;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private double salary;
	@Enumerated(EnumType.STRING)
	private Department department;

}
