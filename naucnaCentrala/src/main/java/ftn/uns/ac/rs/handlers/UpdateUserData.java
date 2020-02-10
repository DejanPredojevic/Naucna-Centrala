package ftn.uns.ac.rs.handlers;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.model.AdminApprovals;
import ftn.uns.ac.rs.model.UserData;
import ftn.uns.ac.rs.repository.AdminRepository;
import ftn.uns.ac.rs.repository.UserDataRepository;

@Service
public class UpdateUserData implements JavaDelegate{
	
	@Autowired
	UserDataRepository userDataRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String procesID = (String) execution.getVariable("procesID");
		List<FormSubmissionRequest> odobrenje = (List<FormSubmissionRequest>) execution.getVariable("odobrenje");
		if(odobrenje.get(0).getFieldValue().equals("true")) {
			System.out.println("USAO");
			AdminApprovals admin =  adminRepository.findByProcesID(procesID).get(0);
			UserData user = userDataRepository.findByUsername(admin.getUsername());
			admin.setStatus("Obradjen");
			user.setOdobrenRecenzent(true);
			adminRepository.save(admin);
			userDataRepository.save(user);
		}
	}
}
