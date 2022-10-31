package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Position;
import com.example.demo.models.department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.PositionRepository;

@Service
public class PositionService {

	@Autowired
	PositionRepository  positionRepository;

	public List<Position> all() {

		return positionRepository.findAll();
	}

	public void create(Position p1) {

		positionRepository.save(p1);
	}

	public ResponseEntity<Position> findById(long id) {

		Position p1 = positionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
		return ResponseEntity.ok(p1);

	}

	public ResponseEntity<Position> update(long id, Position p2) {

		Position p1 = positionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		p2.setId(p1.getId());

		positionRepository.save(p2);

		return ResponseEntity.ok(p2);

	}

	public ResponseEntity<Map<String, Boolean>> delete(long id) {

		Position p1 = positionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		positionRepository.delete(p1);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
