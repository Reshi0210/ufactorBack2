package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.ScaleGroup;

import com.example.demo.repository.ScaleGroupRepository;

@Service
public class ScaleGroupService {

	@Autowired
	ScaleGroupRepository scaleGroupRepository;

	public List<ScaleGroup> all(){

		return scaleGroupRepository.findAll();
	}

	public void create(ScaleGroup s1) {

		scaleGroupRepository.save(s1);
	}
	

	public ResponseEntity<ScaleGroup> findById(long id) {

		ScaleGroup s1 = scaleGroupRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
		return ResponseEntity.ok(s1);

	}

	public ResponseEntity<ScaleGroup> update(long id, ScaleGroup s2) {

		ScaleGroup s1 = scaleGroupRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		s2.setId(s1.getId());

		scaleGroupRepository.save(s2);

		return ResponseEntity.ok(s2);

	}

	public ResponseEntity<Map<String, Boolean>> delete(long id) {

		ScaleGroup s1 = scaleGroupRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		scaleGroupRepository.delete(s1);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
