package ftn.uns.ac.rs.handlers;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.model.ArticleData;
import ftn.uns.ac.rs.model.UserData;
import ftn.uns.ac.rs.repository.ArticleDataRepository;
import ftn.uns.ac.rs.repository.UserDataRepository;

@Service
public class Tematika implements JavaDelegate{
	
	@Autowired
	private ArticleDataRepository articleDataRepository;
	
	@Autowired
	private UserDataRepository userDataRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		List<FormSubmissionRequest> dto = (List<FormSubmissionRequest>) execution.getVariable("dto");
		String procesID = (String) execution.getVariable("procesID");
		
		ArticleData article = articleDataRepository.findByProcesID(procesID);
		
		System.out.println("USAOOOOOOOO MALO DA POGLEDAM ");
		
		for (int i = 0; i < dto.size(); i++) {
			if(dto.get(i).getFieldId().equals("tematika")) {
				article.setPregled(false);
				if(dto.get(i).getFieldValue().equals("true")) {
						article.setTematika(true);
				}else {
					article.setTematika(false);
					article.setTematikaOdbijen(true);
				}
			}else if(dto.get(i).getFieldId().equals("formatiranje")) {
				if(dto.get(i).getFieldValue().equals("true")) {
					article.setFormatiranje(true);
					article.setIspravkaPDF(false);
					String s = article.getMagazine().getUrednici();
					String oblastArtikla = article.getOblast();
					String[] urednici = s.split(",");
					String urednikOblasti = "";
					for(int j = 0; j < urednici.length; j++ ) {
						UserData user = userDataRepository.findByUsername(urednici[j]);
						String s1 = user.getScientificArea();
						String[] oblasti = s1.split(",");
						for(int k = 0; k < oblasti.length; k++ ) {
							if(oblasti[k].equals(oblastArtikla)) {
								article.setUrednikOblasti(user.getUsername());
								urednikOblasti = user.getUsername();
								article.setUrednikIzbor(true);
							}
						}
					}
					if(article.getUrednikOblasti() == null) {
						article.setUrednikOblasti(article.getMagazine().getGlavniUrednik());
						urednikOblasti = article.getMagazine().getGlavniUrednik();
						article.setUrednikIzbor(true);
					}
					execution.setVariable("urednikOblasti", urednikOblasti);
					
				}else {
					article.setFormatiranje(false);
					article.setIspravkaPDF(true);
				}
			
			}else if(dto.get(i).getFieldId().equals("komentar")) {
				article.setKomentar(dto.get(i).getFieldValue());	
			}else if(dto.get(i).getFieldId().equals("vreme")) {
				article.setVremeCekanjaNaIspravku(Long.valueOf(dto.get(i).getFieldValue()));	
			}else {
					article.setTehnickiOdbijen(true);
			}
			
		}
		
		articleDataRepository.save(article);
		
	}

}
