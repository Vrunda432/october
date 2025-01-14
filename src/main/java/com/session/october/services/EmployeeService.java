package com.session.october.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.session.october.dtos.EmployeeRequest;
import com.session.october.entities.Department;
import com.session.october.entities.Employee;
import com.session.october.repository.DepartmentRepository;
import com.session.october.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeService {
private final EmployeeRepository employeeRepository;
private final DepartmentRepository departmentRepository;

public Employee createEmployee(EmployeeRequest request) {
	Optional <Department> opt=departmentRepository.findById(request.getDepartmentId());
	if(opt.isEmpty()) {
		throw new RuntimeException("Invaild Department Id:" + request.getDepartmentId());
		
	}
	Department dept=opt.get();
//	Employee employee=new Employee();
//	employee.setName(request.getName());
//	employee.setDepartment(dept);// 
	
	Employee employee = Employee.builder().name(request.getName()).department(dept).build();
	return employeeRepository.save(employee);//this will save in database in tbl
}


}