package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.PoliticIntegration;

import com.example.demo.service.PoliticIntegrationService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/politic")
public class PoliticIntegrationController {
	
	@Autowired
	PoliticIntegrationService politicIntegrationService ;

	
	@GetMapping("/all")
	public List<PoliticIntegration> FindAll(){
		
		return politicIntegrationService.all();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody PoliticIntegration p1) {
		politicIntegrationService.create(p1);
	}
    
	@GetMapping("/findById/{id}")
	public ResponseEntity<PoliticIntegration> findByIdl(@PathVariable long id){
		
	return politicIntegrationService.findById(id);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<PoliticIntegration> update(@PathVariable long id,@RequestBody PoliticIntegration p2){
		return politicIntegrationService.update(id, p2);
	}
	
	@DeleteMapping("delete/{id}")
	public  ResponseEntity<Map<String,Boolean>> deleteWorker(@PathVariable long id) {
		
		return politicIntegrationService.delete(id);
 }
	
}

