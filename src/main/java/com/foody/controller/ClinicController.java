package com.foody.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foody.dto.ClinicRequest;
import com.foody.payload.DataResponse;
import com.foody.security.CurrentUser;
import com.foody.security.UserPrincipal;
import com.foody.services.ClinicService;

@RestController
@RequestMapping("/api/clinic")
public class ClinicController {
	
	@Autowired
	ClinicService ClinicService;
	
	@PreAuthorize("hasRole('EXPERT')")
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public DataResponse registerDoctor(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody ClinicRequest clinicRequest){
		return ClinicService.addClinicCurrentDoctor(currentUser, clinicRequest);
	}
	
}
