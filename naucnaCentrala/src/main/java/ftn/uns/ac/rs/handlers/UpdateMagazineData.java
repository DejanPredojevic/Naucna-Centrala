package ftn.uns.ac.rs.handlers;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.model.MagazineData;
import ftn.uns.ac.rs.repository.AdminRepository;
import ftn.uns.ac.rs.repository.MagazineDataRepository;
import ftn.uns.ac.rs.repository.UserDataRepository;

@Service
public class UpdateMagazineData implements JavaDelegate{

	@Autowired
	UserDataRepository userDataRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	MagazineDataRepository magazineDataRepository;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Usao da sacuvam podatke..da.");
		List<FormSubmissionRequest> data = (List<FormSubmissionRequest>) execution.getVariable("odobrenje");
		String procesID = (String) execution.getVariable("procesID");
		
		MagazineData magazine = magazineDataRepository.findByProcesID(procesID);
		magazine = createMagazineData(data,magazine);
		magazineDataRepository.save(magazine);
		
	}
	
	
	private MagazineData createMagazineData(List<FormSubmissionRequest> dto , MagazineData data) {
		for (int i = 0; i < dto.size(); i++) {
			if(dto.get(i).getFieldId().equals("urednici")) {
				data.setUrednici(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("recenzenti")) {
				data.setRecenzenti(dto.get(i).getFieldValue());
			}
		}
		return data;
	}
	
}