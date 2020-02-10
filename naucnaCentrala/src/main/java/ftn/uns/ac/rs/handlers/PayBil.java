package ftn.uns.ac.rs.handlers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.model.Clanarina;
import ftn.uns.ac.rs.model.MagazineData;
import ftn.uns.ac.rs.model.UserData;
import ftn.uns.ac.rs.repository.ClanarinaRepository;
import ftn.uns.ac.rs.repository.MagazineDataRepository;
import ftn.uns.ac.rs.repository.UserDataRepository;

@Service
public class PayBil implements JavaDelegate{

	@Autowired
	MagazineDataRepository magazineDataRepository;
	
	@Autowired
	UserDataRepository userDataRepository;
	
	@Autowired
	ClanarinaRepository clanarinaRepository;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		System.out.println("USAO U PayBILL ::::::::::::!!!!!!!!!!!!!!");
		
		List<FormSubmissionRequest> dto = (List<FormSubmissionRequest>) execution.getVariable("magazineProces");
		String procesID = (String) execution.getVariable("procesID");
		String username = (String) execution.getVariable("username");
		
		String magazineProcesId = "";
		for (int i = 0; i < dto.size(); i++) {
			if(dto.get(i).getFieldId().equals("casopis")) {
				magazineProcesId = dto.get(i).getFieldValue();
			}
		}
		
		MagazineData magazine = magazineDataRepository.findByProcesID(magazineProcesId);
		UserData user = userDataRepository.findByUsername(username);
		Clanarina clanarina = new Clanarina();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		Date result = cal.getTime();
		clanarina.setDatumDo(result);
		clanarina.setKorisnik(user);
		clanarina.setMagazine(magazine);
		clanarina.setNaziv("Autor uplacuje clanarinu");
		clanarina.setUrednik(false);
		clanarina.setCena(500);
		
		clanarinaRepository.save(clanarina);
		
	}

}