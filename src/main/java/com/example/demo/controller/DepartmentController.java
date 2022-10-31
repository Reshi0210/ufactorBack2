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


import com.example.demo.models.department;
import com.example.demo.service.DepartmentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmenService;

	
	@GetMapping("/all")
	public List<department> FindAll(){
		
		return departmenService.all();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody department d1) {
		departmenService.create(d1);
	}
    
	@GetMapping("/findById/{id}")
	public ResponseEntity<department> findByIdl(@PathVariable long id){
		
	return departmenService.findById(id);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<department> update(@PathVariable long id,@RequestBody department d2){
		return departmenService.update(id, d2);
	}
	
	@DeleteMapping("delete/{id}")
	public  ResponseEntity<Map<String,Boolean>> deleteWorker(@PathVariable long id) {
		
		return departmenService.delete(id);
	}
	
}

