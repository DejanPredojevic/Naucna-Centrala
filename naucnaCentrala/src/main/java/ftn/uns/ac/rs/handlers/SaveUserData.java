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
public class SaveUserData implements JavaDelegate{

	@Autowired
	UserDataRepository userDataRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		UserData userData = createUserData((List<FormSubmissionRequest>) execution.getVariable("userData"));
		userDataRepository.save(userData);
		System.out.println("USAOOOOOOOOOOOOO");
		String procesID = (String) execution.getVariable("procesID");
		if(userData.getRecenzent()) {
			AdminApprovals admin = new AdminApprovals();
			admin.setProcesID(procesID);
			admin.setUsername(userData.getUsername());
			admin.setStatus("Obrada");
			adminRepository.save(admin);
		}
	}
	
	private UserData createUserData(List<FormSubmissionRequest> dto) {
		UserData userData = new UserData();
		for (int i = 0; i < dto.size(); i++) {
			if(dto.get(i).getFieldId().equals("oblast")) {
				userData.setScientificArea(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("ime")) {
				userData.setIme(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("prezime")) {
				userData.setPrezime(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("grad")) {
				userData.setGrad(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("titula")) {
				userData.setTitula(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("email")) {
				userData.setEmail(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("recenzent")) {
				if(dto.get(i).getFieldValue().equals("true")) {
					userData.setRecenzent(true);
				}else{
					userData.setRecenzent(false);
				}
				userData.setOdobrenRecenzent(false);
			}
			if(dto.get(i).getFieldId().equals("username")) {
				userData.setUsername(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("password")) {
				userData.setPassword(dto.get(i).getFieldValue());
			}
		}
		
		
		return userData;
	}
}