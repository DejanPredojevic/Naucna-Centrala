package ftn.uns.ac.rs.handlers;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.model.ArticleData;
import ftn.uns.ac.rs.repository.ArticleDataRepository;

@Service
public class Tematika implements JavaDelegate{
	
	@Autowired
	private ArticleDataRepository articleDataRepository;

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
