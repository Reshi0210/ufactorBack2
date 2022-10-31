package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Scholarship;

import com.example.demo.repository.ScholarShipRepository;

@Service
public class ScholarShipService {

	@Autowired
	ScholarShipRepository scholarShipRepository ;

	public List<Scholarship> all() {

		return scholarShipRepository.findAll();
	}

	public void create(Scholarship s1) {

		scholarShipRepository.save(s1);
	}

	public ResponseEntity<Scholarship> findById(long id) {

		Scholarship s1 = scholarShipRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
		return ResponseEntity.ok(s1);

	}

	public ResponseEntity<Scholarship> update(long id, Scholarship s2) {

		Scholarship s1 = scholarShipRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		s2.setId(s1.getId());

		scholarShipRepository.save(s2);

		return ResponseEntity.ok(s2);

	}

	public ResponseEntity<Map<String, Boolean>> delete(long id) {

		Scholarship s1 = scholarShipRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		scholarShipRepository.delete(s1);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
