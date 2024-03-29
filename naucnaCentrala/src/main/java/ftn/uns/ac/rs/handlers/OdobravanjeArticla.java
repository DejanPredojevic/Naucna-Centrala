package ftn.uns.ac.rs.handlers;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.model.ArticleData;
import ftn.uns.ac.rs.repository.ArticleDataRepository;

@Service
public class OdobravanjeArticla implements JavaDelegate{

	@Autowired
	ArticleDataRepository articleDataRepository;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		System.out.println("USAO SAM U BasicInfoSAve !!!!!!!!!!!!!!!!!!!!!");
		List<FormSubmissionRequest> dto = (List<FormSubmissionRequest>) execution.getVariable("dto");
		String procesID = (String) execution.getVariable("procesID");
		
		ArticleData article = articleDataRepository.findByProcesID(procesID);
		article = createArticleData(dto,article);
		System.out.println("menajm pregled na trueeeee ;;;;;;;;");
		article.setUrednikPregledaRecenziju(false);
		articleDataRepository.save(article);
	}
	
	private ArticleData createArticleData(List<FormSubmissionRequest> dto, ArticleData article) throws IOException, SQLException, SQLException {
		for (int i = 0; i < dto.size(); i++) {
			if(dto.get(i).getFieldId().equals("odobren")) {
				if(dto.get(i).getFieldValue().equals("true")) {
					article.setOdobren(true);
					
				}else
					article.setOdobren(false);
			}
			if(dto.get(i).getFieldId().equals("odbijen")) {
				if(dto.get(i).getFieldValue().equals("true")) {
					article.setOdbijen(true);
					
				}else
					article.setOdbijen(false);
			}
		}
		
		
		return article;
	}
}
