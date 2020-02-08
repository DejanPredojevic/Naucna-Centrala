package ftn.uns.ac.rs.dto;

import java.util.List;

import org.camunda.bpm.engine.form.FormField;

import ftn.uns.ac.rs.model.MagazineData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FormAdminCheckResponse {
	
	String taskId;
	String processInstanceId;
	List<FormField> formFields;
	MagazineData magazine;
}
