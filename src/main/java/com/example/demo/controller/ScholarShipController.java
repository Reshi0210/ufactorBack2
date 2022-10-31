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

import com.example.demo.models.Scholarship;
import com.example.demo.models.department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.ScholarShipService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/scholar")
public class ScholarShipController {
	
	@Autowired
	ScholarShipService scholarShipService ;

	
	@GetMapping("/all")
	public List<Scholarship> FindAll(){
		
		return scholarShipService.all();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody Scholarship s1) {
		scholarShipService.create(s1);
	}
    
	@GetMapping("/findById/{id}")
	public ResponseEntity<Scholarship> findByIdl(@PathVariable long id){
		
	return scholarShipService.findById(id);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Scholarship> update(@PathVariable long id,@RequestBody Scholarship d2){
		return scholarShipService.update(id, d2);
	}
	
	@DeleteMapping("delete/{id}")
	public  ResponseEntity<Map<String,Boolean>> deleteWorker(@PathVariable long id) {
		
		return scholarShipService.delete(id);
	}
	
}

