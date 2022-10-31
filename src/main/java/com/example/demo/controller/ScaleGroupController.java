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

import com.example.demo.models.ScaleGroup;

import com.example.demo.service.ScaleGroupService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/scaleGroup")
public class ScaleGroupController {
	
	@Autowired
	ScaleGroupService scalegroupService;

	
	@GetMapping("/all")
	public List<ScaleGroup> FindAll(){
		
		return scalegroupService.all();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody ScaleGroup s1) {
		scalegroupService.create(s1);
	}
    
	@GetMapping("/findById/{id}")
	public ResponseEntity<ScaleGroup> findByIdl(@PathVariable long id){
		
	return scalegroupService.findById(id);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<ScaleGroup> update(@PathVariable long id,@RequestBody ScaleGroup s2){
		return scalegroupService.update(id, s2);
	}
	
	@DeleteMapping("delete/{id}")
	public  ResponseEntity<Map<String,Boolean>> delete(@PathVariable long id) {
		
		return scalegroupService.delete(id);
	}
	
}

