package com.example.demo.service;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import utilities.AgeUtilities;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.WorkerRepository;

@Service
public class WorkerService {

	Worker worker = new Worker();

	@Autowired
	WorkerRepository workerRepository;
	DepartmentRepository departmentRepository;
	
	
	

	public Page<Worker> allWorkers(Integer page, Integer size) {
		
       return workerRepository.findAll(PageRequest.of(page,size));
	}
	
	

	public ResponseEntity<Worker> createWorker(Worker w1) {
		w1.setAge(AgeUtilities.CalculateAge(w1.getCi()));
		setDefaultCareerPlan(w1);
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

	

    public List<Worker>  filterE(Worker worker,Integer min,Integer max) {
		scholarLevel ScholarLevel;
		String department;


		if (worker.getScholarShip() != null) ScholarLevel = worker.getScholarShip().getScholarLevel();
		else ScholarLevel = null;

		if (worker.getDepartment() != null) department = worker.getDepartment().getDepartamentName();
		else department = null;

		String firstName=worker.getFirstName();
		String secondName=worker.getSecondName();
		String lastName=worker.getLastName();
		race race=worker.getRace();
		contractType contractType=worker.getContractType();
		String expedientNumber=worker.getExpedientNumber();
		active active=worker.getActive();
		sex sex=worker.getSex();
		defensePlace defensePlace=worker.getDefensePlace();
		return workerRepository.filter(ScholarLevel,firstName,secondName,lastName,race,contractType,expedientNumber,active,sex,defensePlace,department,min,max);

	}


	public List<Worker> filterByCriteria(String criteria) {

    LinkedList<Worker> result = new LinkedList<>();

		result.addAll(workerRepository.findByFirstNameStartsWith(criteria));

		if (result.isEmpty()) {
			result.addAll(workerRepository.findByCiStartsWith(criteria));
		}

		return (List<Worker>) result;
	}

	public List<Worker> filterByNed(Scholarship scholarship){
		return workerRepository.filterByNed(scholarship);
	}
	
	

	private void setDefaultCareerPlan(Worker w){
		CareerPlan c=new CareerPlan();
		Scholarship ds=new Scholarship();
		ds.setId(5);
		c.setDoctorado(ds);
		c.setDoctoradoP(ds);
		c.setDoctoradoF(ds);
		c.setAcreditacion(ds);
		c.setAcreditacionF(ds);
		c.setAcreditacionP(ds);
		c.setFormacionPiramidal(ds);
		c.setFormacionPiramidalP(ds);
		c.setFormacionPiramidalF(ds);
		c.setIdiomaelemental(ds);
		c.setIdiomaelementalP(ds);
		c.setIdiomaelementalF(ds);
		c.setIdiomaOptimo(ds);
		c.setIdiomaOptimoP(ds);
		c.setIdiomaOptimoF(ds);
		c.setMaster(ds);
		c.setMasterP(ds);
		c.setMasterF(ds);
		c.setPosgrado1(ds);
		c.setPosgrado1P(ds);
		c.setPosgrado1F(ds);
		c.setPosgrado2(ds);
		c.setPosgrado2P(ds);
		c.setPosgrado2F(ds);
		w.setCareerPlan(c);

	}
	

}
