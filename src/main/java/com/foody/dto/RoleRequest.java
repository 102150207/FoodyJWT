package com.foody.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.foody.entities.Role;

public class RoleRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public RoleRequest() {
		
	}
	
	@NotNull
    @Valid
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Role setRole(RoleRequest roleRequest) {
		return new Role(roleRequest.getName());
	}
}
