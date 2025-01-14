package com.session.october.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.session.october.dtos.EmployeeRequest;
import com.session.october.entities.Employee;
import com.session.october.services.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeControllers {
	
	private final EmployeeService employeeService;
	
	@PostMapping("/new")  
	  public ResponseEntity<Employee>createEmployee(@RequestBody @Validated EmployeeRequest request){
		  return ResponseEntity.ok(employeeService.createEmployee(request));
	  }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>handleValidationExceptions(
			MethodArgumentNotValidException ex){
			Map<String,String>errors= new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error)->{
				String fieldName=((FieldError)error).getField();
				String errorMessage=error.getDefaultMessage();
				errors.put(fieldName,errorMessage);
			
			});
			
			return ResponseEntity.badRequest().body(errors);
			
	}
	
	
}
//  private static Map<Integer,Object>employees=new HashMap<>();
//  
//  {
//	  
//	  Map <String,Object>emp1=new HashMap<>();
//	  emp1.put("id", 1);
//	  emp1.put("name", "Vrunda");
//	  employees.put(1, emp1);
//	  
//	  Map <String,Object>emp2=new HashMap<>();
//	  emp2.put("id", 2);
//	  emp2.put("name", "Viren");
//	  employees.put(2, emp2);
//	  
//	  Map <String,Object>emp3=new HashMap<>();
//	  emp3.put("id", 3);
//	  emp3.put("name", "Viraj");
//	  employees.put(3, emp3);
//	  
//	  
//	  Map <String,Object>emp4=new HashMap<>();
//	  emp4.put("id", 4);
//	  emp4.put("name", "Vraj");
//	  employees.put(4, emp4);
//	  
//	  Map <String,Object>emp5=new HashMap<>();
//	  emp5.put("id", 5);
//	  emp5.put("name", "puja");
//	  employees.put(5, emp5);
//	  
//	  
//	  Map <String,Object>emp6=new HashMap<>();
//	  emp6.put("id", 6);
//	  emp6.put("name", "nayan");
//	  employees.put(6, emp6);
//	  
//	  
//  }
//  @GetMapping("/all")
//  public  ResponseEntity<?> getAllEmployees(){
//	  return ResponseEntity.ok(employees);
//  }
//  
//  @GetMapping("/{id}")
//  public ResponseEntity<?> getAllEmployeeDetails(@PathVariable    int id){
//	  return ResponseEntity.ok(employees.get(id));
//  }
// 
//  @PostMapping
//  public ResponseEntity<?> createNewEmployee(@RequestBody Map <String,Object>request){
//	  if(request.get("id")==null) {
//		  return ResponseEntity.internalServerError().body("No ID found");
//		  
//	  }
//	  if(employees.get((int)request.get("id"))!= null) {
//		  return ResponseEntity.badRequest().body("Employee with the same ID already Exists");
//		  
//	  }
//	  int id =(int)request.get("id");
//	  employees.put(id,request);
//	  return ResponseEntity.ok(employees.get(id));
//  }
//  @PutMapping("/{id}")
//  public ResponseEntity<?> updateExistingEmployee(@PathVariable int id,@RequestBody Map <String,Object>request){
//	  if(employees.get(id)==null) {
//		  return ResponseEntity.internalServerError().body("No ID found");
//	  }
//	 // employees.put(id,request.get("name"));
//	  Map<String, Object> newMap = (Map<String, Object>) employees.get(id);
//	   String previous= (String)newMap.put("name", request.get("name"));
//	  log.info("{}name updated to {} for Employees.id{}",previous,request.get("id"),id);
//	  return ResponseEntity.ok(employees.get(id));
//  }
//  @DeleteMapping("/{id}")
//  public ResponseEntity<HttpStatus>deleteById(@PathVariable int id){
//	  Map<String, Object>entry = (Map<String, Object>) employees.remove(id);
//	log.info("Employee removed with id: {} and name: {}", id, entry.get("name"));
//    return ResponseEntity.ok().build();
//  }
//  
  

