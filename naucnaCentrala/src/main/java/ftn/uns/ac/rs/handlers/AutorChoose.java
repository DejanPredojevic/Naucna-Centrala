package ftn.uns.ac.rs.handlers;

import java.util.Date;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.model.ArticleData;
import ftn.uns.ac.rs.model.Clanarina;
import ftn.uns.ac.rs.model.MagazineData;
import ftn.uns.ac.rs.model.UserData;
import ftn.uns.ac.rs.repository.ArticleDataRepository;
import ftn.uns.ac.rs.repository.ClanarinaRepository;
import ftn.uns.ac.rs.repository.MagazineDataRepository;
import ftn.uns.ac.rs.repository.UserDataRepository;

@Service
public class AutorChoose implements JavaDelegate{

	@Autowired
	MagazineDataRepository magazineDataRepository;
	
	@Autowired
	UserDataRepository userDataRepository;
	
	@Autowired
	ClanarinaRepository clanarinaRepository;
	
	@Autowired
	ArticleDataRepository articleDataRepository;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		System.out.println("USAO U AUTOR CHOSEE ::::::::::::!!!!!!!!!!!!!!");
		
		List<FormSubmissionRequest> dto = (List<FormSubmissionRequest>) execution.getVariable("magazineProces");
		String procesID = (String) execution.getVariable("procesID");
		String username = (String) execution.getVariable("username");
		
		String magazineProcesId = "";
		for (int i = 0; i < dto.size(); i++) {
			if(dto.get(i).getFieldId().equals("casopis")) {
				magazineProcesId = dto.get(i).getFieldValue();
			}
		}
		System.out.println(magazineProcesId);
		System.out.println(magazineDataRepository);
		MagazineData magazine = magazineDataRepository.findByProcesID(magazineProcesId);
		UserData user = userDataRepository.findByUsername(username);
		List<Clanarina> clanarina = clanarinaRepository.findByKorisnikAndMagazine(user, magazine);
		
		
		if(magazine.getOpenAccess() == true)
			execution.setVariable("clanarina", true);
		else {
			if(clanarina == null) {
				execution.setVariable("clanarina", false);
			}else {
				boolean temp = false;
				for (Clanarina clanarina2 : clanarina) {
					if(clanarina2.getDatumDo().after(new Date())) {
						temp = true;
					}
				}
				execution.setVariable("clanarina", temp);
			}
		
		}
		
		ArticleData article = new ArticleData();
		article.setMagazine(magazine);
		article.setAutor(user);
		article.setProcesID(procesID);
		articleDataRepository.save(article);
		
	}

}
