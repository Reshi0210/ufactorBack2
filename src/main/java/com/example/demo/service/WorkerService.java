package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.PoliticIntegration;
import com.example.demo.models.Scholarship;
import com.example.demo.models.Worker;
import com.example.demo.models.contractType;
import com.example.demo.models.defensePlace;
import com.example.demo.models.department;
import com.example.demo.models.race;
import com.example.demo.models.sex;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.WorkerRepository;

@Service
public class WorkerService {

	Worker worker = new Worker();

	@Autowired
	WorkerRepository workerRepository;
	DepartmentRepository departmentRepository;
	
	

	public List<Worker> allWorkers() {
		
       return workerRepository.findAll();
	}
	
	

	public ResponseEntity<Worker> createWorker(Worker w1) {
		
        workerRepository.save(w1);
        return ResponseEntity.ok(w1);

	}
	
	

	public ResponseEntity<Worker> findByIdl(long CI) {

		Worker w1 = workerRepository.findById(CI).orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
		return ResponseEntity.ok(w1);

	}
	
	
	
	

	public ResponseEntity<Worker> updateWorker(long CI, Worker w2) {

		Worker w1 = workerRepository.findById(CI).orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
        w2.setId(w1.getId());
        workerRepository.save(w2);
        return ResponseEntity.ok(w2);

	}
	
	

	public ResponseEntity<Map<String, Boolean>> deleteWorker(long CI) {

		Worker w1 = workerRepository.findById(CI).orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
        workerRepository.delete(w1);
        Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	///////////// filters//////////////////////////////////////////////////////
	
	

	public List<Worker> filter(String name) {

		return workerRepository.findByFirstNameContaining(name);

	}
	
	
	public List<Worker> findBySecondName(String secondName) {
		return workerRepository.findBySecondNameContaining(secondName);
	}
	

	public List<Worker> filterS(sex sex) {

		return workerRepository.findBySex(sex);

	}
	
	

	public List<Worker> fil(sex sex, race race, String depa, contractType contractType, defensePlace defensePlace) {
       ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();

		if (depa != null) {
			department depar = new department();
			depar.setDepartamentName(depa);
			worker.setDepartment(depar);
		}

		worker.setSex(sex);
		worker.setRace(race);
		worker.setContractType(contractType);
		worker.setDefensePlace(defensePlace);

		Example<Worker> exampleQuery = Example.of(worker, matcher);

		return workerRepository.findAll(exampleQuery);
	}
	
	

	public List<Worker> filterByExample(Worker worker) {

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Worker> exampleQuery = Example.of(worker, matcher);
        return workerRepository.findAll(exampleQuery);
	}
	
	
	
    public List<Worker> filterE(Worker worker, String level) {

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Worker> exampleQuery = Example.of(worker, matcher);
        LinkedList<Worker> result = new LinkedList<>();

		if (level != "" && level != null) {
			workerRepository.findAll(exampleQuery).forEach((w) -> {
				for (Scholarship l : w.getScholarShiplist()) {
					if (l.getScholarLevel().toString().equals(level)) {
						result.add(w);
					}

				}

			});

			return (List<Worker>) result;
		} else {
			return workerRepository.findAll(exampleQuery);
		}
	}
    

	public List<Worker> filterByCriteria(String criteria) {
		
    LinkedList<Worker> result = new LinkedList<>();

		result.addAll(workerRepository.findByFirstNameStartsWith(criteria));

		if (result.isEmpty()) {
			result.addAll(workerRepository.findByCiStartsWith(criteria));
		}

		return (List<Worker>) result;
	}
	
	

	
	

}
