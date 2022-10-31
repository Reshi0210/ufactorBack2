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

import com.example.demo.models.Position;

import com.example.demo.service.PositionService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/position")
public class PositionController {
	
	@Autowired
	PositionService positionService;

	
	@GetMapping("/all")
	public List<Position> FindAll(){
		
		return positionService.all();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody Position p1) {
		positionService.create(p1);
	}
    
	@GetMapping("/findById/{id}")
	public ResponseEntity<Position> findByIdl(@PathVariable long id){
		
	return positionService.findById(id);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Position> update(@PathVariable long id,@RequestBody Position p2){
		return positionService.update(id, p2);
	}
	
	@DeleteMapping("delete/{id}")
	public  ResponseEntity<Map<String,Boolean>> deleteWorker(@PathVariable long id) {
		
		return positionService.delete(id);
	}
	
}

