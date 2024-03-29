package ftn.uns.ac.rs.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ftn.uns.ac.rs.dto.FormAdminCheckResponse;
import ftn.uns.ac.rs.dto.FormArticleResponse;
import ftn.uns.ac.rs.dto.FormEnumResponse;
import ftn.uns.ac.rs.dto.FormFieldsResponse;
import ftn.uns.ac.rs.dto.FormOdobravanjeArticlaResponse;
import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.dto.ProcesDto;
import ftn.uns.ac.rs.model.ArticleData;
import ftn.uns.ac.rs.services.NewArticleService;

@Controller
public class NewArticleController {
	
	@Autowired
	NewArticleService newArticleService;
	
	@GetMapping(path = "/startNewArticle", produces = "application/json")
    public ResponseEntity<FormArticleResponse> startRegistration() {
		FormArticleResponse paymentOrderResponse = newArticleService.start();
        return ResponseEntity.ok().body(paymentOrderResponse);
    }
	
	@PostMapping(path = "/chooseMagazine/{taskId}/{username}", produces = "application/json")
    public ResponseEntity<Boolean> chooseMagazine(@RequestBody List<FormSubmissionRequest> dto, @PathVariable String taskId, @PathVariable String username) {
		Boolean response = newArticleService.chooseMagazine(dto,taskId,username);
		return ResponseEntity.ok().body(response);
    }
	
	@GetMapping(path = "/getBasicInfo/{processInstanceId}", produces = "application/json")
    public ResponseEntity<FormFieldsResponse> getBasicInfo(@PathVariable String processInstanceId) {
		FormFieldsResponse formFieldsResponse = newArticleService.getBasicInfo(processInstanceId);
        return ResponseEntity.ok().body(formFieldsResponse);
    }
    
    @GetMapping(path = "/getRecenzetChoose/{processInstanceId}", produces = "application/json")
    public ResponseEntity<FormFieldsResponse> getRecenzetChoose(@PathVariable String processInstanceId) {
		FormFieldsResponse formFieldsResponse = newArticleService.getRecenzetChoose(processInstanceId);
        return ResponseEntity.ok().body(formFieldsResponse);
    }
    
    @GetMapping(path = "/getOdobravanje/{processInstanceId}", produces = "application/json")
    public ResponseEntity<FormOdobravanjeArticlaResponse> getOdobravanje(@PathVariable String processInstanceId) {
    	FormOdobravanjeArticlaResponse formOdobravanjeArticlaResponse = newArticleService.getOdobravanje(processInstanceId);
        return ResponseEntity.ok().body(formOdobravanjeArticlaResponse);
    }
	
	@GetMapping(path = "/getPath", produces = "application/json")
    public ResponseEntity<ProcesDto> getPath() {
		ProcesDto path = newArticleService.getPath();
        return ResponseEntity.ok().body(path);
    }
    
    @PostMapping(path = "/downloadPDF/{procesId}", produces = "application/json")
    public ResponseEntity<Boolean> downloadPDF(@PathVariable String procesId) throws SQLException {
		newArticleService.downloadPDF(procesId);
		return ResponseEntity.ok().body(true);
    }
	
	@PostMapping(path = "/saveRecenzente/{procesId}", produces = "application/json")
    public ResponseEntity<Boolean> saveRecenzente(@RequestBody List<FormSubmissionRequest> dto, @PathVariable String procesId) {
		Boolean valid = newArticleService.saveRecenzente(dto,procesId);
		return ResponseEntity.ok().body(valid);
    }
	
	@PostMapping(path = "/saveBasicInfo/{procesId}", produces = "application/json")
    public ResponseEntity<Boolean> saveBasicInfo(@RequestBody List<FormSubmissionRequest> dto, @PathVariable String procesId) {
		Boolean valid = newArticleService.saveBasicInfo(dto,procesId);
		return ResponseEntity.ok().body(valid);
    }
	
    @PostMapping(path = "/saveRecenziju/{procesId}", produces = "application/json")
    public ResponseEntity<Boolean> saveRecenziju(@RequestBody List<FormSubmissionRequest> dto, @PathVariable String procesId) {
		Boolean valid = newArticleService.saveRecenziju(dto,procesId);
		return ResponseEntity.ok().body(valid);
    }
    
	@GetMapping(path = "/getTematika", produces = "application/json")
    public ResponseEntity<List<ArticleData>> getTematika() {
		List<ArticleData> articles = newArticleService.getAllArticleForCheck();
        return ResponseEntity.ok().body(articles);
    }
	
	@GetMapping(path = "/getForPdfCorection", produces = "application/json")
    public ResponseEntity<List<ArticleData>> getForPdfCorection() {
		List<ArticleData> articles = newArticleService.getPdfCorect();
        return ResponseEntity.ok().body(articles);
    }
    
    @GetMapping(path = "/getPregledRecenzija", produces = "application/json")
    public ResponseEntity<List<ArticleData>> getPregledRecenzija() {
		List<ArticleData> articles = newArticleService.getPregledRecenzija();
        return ResponseEntity.ok().body(articles);
    }
	
	@PostMapping(path = "/saveTematika/{procesId}", produces = "application/json")
    public ResponseEntity<Boolean> saveTematika(@RequestBody List<FormSubmissionRequest> dto, @PathVariable String procesId) {
		Boolean valid = newArticleService.saveTematika(dto,procesId);
		return ResponseEntity.ok().body(valid);
    }
	
	@GetMapping(path = "/getForUrednikChoose/{username}", produces = "application/json")
    public ResponseEntity<List<ArticleData>> getForUrednikChoose(@PathVariable String username) {
		List<ArticleData> articles = newArticleService.getForUrednikChoose(username);
        return ResponseEntity.ok().body(articles);
    }
	
	@GetMapping(path = "/getForRecenziju/{username}", produces = "application/json")
    public ResponseEntity<List<ArticleData>> getForRecenziju(@PathVariable String username) {
		List<ArticleData> articles = newArticleService.getForRecenziju(username);
        return ResponseEntity.ok().body(articles);
    }
}
