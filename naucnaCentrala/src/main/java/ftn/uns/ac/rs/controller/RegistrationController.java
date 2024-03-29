package ftn.uns.ac.rs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ftn.uns.ac.rs.dto.FormFieldsResponse;
import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.dto.LoginRequest;
import ftn.uns.ac.rs.dto.LoginResponse;
import ftn.uns.ac.rs.model.AdminApprovals;
import ftn.uns.ac.rs.services.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@GetMapping(path = "/startRegistration", produces = "application/json")
    public ResponseEntity<FormFieldsResponse> startRegistration() {
		FormFieldsResponse paymentOrderResponse = registrationService.start();
        return ResponseEntity.ok().body(paymentOrderResponse);
    }
	
	@PostMapping(path = "/register/{taskId}", produces = "application/json")
    public ResponseEntity<Boolean> register(@RequestBody List<FormSubmissionRequest> dto, @PathVariable String taskId) {
		Boolean valid = registrationService.register(dto,taskId);
		return ResponseEntity.ok().body(valid);
        
    }
	
	@GetMapping(path = "/getUsersApproval", produces = "application/json")
    public ResponseEntity<List<AdminApprovals>> getUsersApproval() {
		List<AdminApprovals> usersApproval = registrationService.getUserApproval();
        return ResponseEntity.ok().body(usersApproval);
    }
	
	@GetMapping(path = "/getAdminApprove/{processInstanceId}", produces = "application/json")
    public ResponseEntity<FormFieldsResponse> getAdminApprove(@PathVariable String processInstanceId) {
		FormFieldsResponse paymentOrderResponse = registrationService.getApproval(processInstanceId);
        return ResponseEntity.ok().body(paymentOrderResponse);
    }
	
	@PostMapping(path = "/approveUser/{procesId}", produces = "application/json")
    public ResponseEntity<Boolean> approveUser(@RequestBody List<FormSubmissionRequest> dto, @PathVariable String procesId) {
		Boolean valid = registrationService.approveUser(dto,procesId);
		return ResponseEntity.ok().body(valid);
        
    }
	
	@PostMapping(path = "/login", produces = "application/json")
	public ResponseEntity<LoginResponse> loginKorisnik(@RequestBody LoginRequest loginRequest) throws Exception{
		return new ResponseEntity<LoginResponse>(registrationService.login(loginRequest), HttpStatus.OK);
	}

}
