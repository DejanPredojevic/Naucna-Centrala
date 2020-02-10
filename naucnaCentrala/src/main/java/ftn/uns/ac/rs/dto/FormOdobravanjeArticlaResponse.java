package ftn.uns.ac.rs.dto;

import java.util.List;

import org.camunda.bpm.engine.form.FormField;

import ftn.uns.ac.rs.model.ArticleData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FormOdobravanjeArticlaResponse {
	
	String taskId;
	String processInstanceId;
	List<FormField> formFields;
	ArticleData article;
}
