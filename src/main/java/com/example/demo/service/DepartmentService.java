package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public List<department> all() {

		return departmentRepository.findAll();
	}

	public void create(department d1) {

		departmentRepository.save(d1);
	}

	public ResponseEntity<department> findById(long id) {

		department d1 = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
		return ResponseEntity.ok(d1);

	}

	public ResponseEntity<department> update(long id, department d2) {

		department d1 = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		d2.setId(d1.getId());

		departmentRepository.save(d2);

		return ResponseEntity.ok(d2);

	}

	public ResponseEntity<Map<String, Boolean>> delete(long id) {

		department d1 = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));

		departmentRepository.delete(d1);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
