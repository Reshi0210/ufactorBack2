package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.PoliticIntegration;

import com.example.demo.repository.PoliticIntegrationRepository;

@Service
public class PoliticIntegrationService {

	@Autowired
	PoliticIntegrationRepository politicIntegrationRepository;

	public List<PoliticIntegration> all() {

		return politicIntegrationRepository.findAll();
	}

	public void create(PoliticIntegration p1) {

		politicIntegrationRepository.save(p1);
	}

	public ResponseEntity<PoliticIntegration> findById(long id) {

		PoliticIntegration p1 = politicIntegrationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
		return ResponseEntity.ok(p1);

	}

	public ResponseEntity<PoliticIntegration> update(long id, PoliticIntegration p2) {

		PoliticIntegration p1 = politicIntegrationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		p2.setId(p1.getId());

		politicIntegrationRepository.save(p2);

		return ResponseEntity.ok(p2);

	}

	public ResponseEntity<Map<String, Boolean>> delete(long id) {

		PoliticIntegration p1 = politicIntegrationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		politicIntegrationRepository.delete(p1);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
