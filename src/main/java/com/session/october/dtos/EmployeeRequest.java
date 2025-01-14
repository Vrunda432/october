package com.session.october.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmployeeRequest {
	@NotBlank(message="name is required.")
	private String name;
	
@NotNull(message="departmentId is required.")
private Long departmentId;
}
