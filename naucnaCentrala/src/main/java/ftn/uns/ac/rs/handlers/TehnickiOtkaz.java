package ftn.uns.ac.rs.handlers;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.model.ArticleData;
import ftn.uns.ac.rs.repository.ArticleDataRepository;

@Service
public class TehnickiOtkaz implements JavaDelegate{
	
	@Autowired
	private ArticleDataRepository articleDataRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String procesID = (String) execution.getVariable("procesID");
		
		ArticleData article = articleDataRepository.findByProcesID(procesID);
		
		article.setPregled(false);
		article.setTehnickiOdbijen(true);
		article.setIspravkaPDF(false);
		System.out.println("TEHNICKI OTKAZ >>>>>>>>>>>??????????????<<<<<<<<<<<<<<");
		articleDataRepository.save(article);
		
	}

}
