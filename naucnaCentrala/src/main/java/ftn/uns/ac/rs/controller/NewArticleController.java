package ftn.uns.ac.rs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ftn.uns.ac.rs.dto.FormArticleResponse;
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

}
