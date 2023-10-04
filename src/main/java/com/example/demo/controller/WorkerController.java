package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.models.*;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.WorkerService;

import utilities.AgeUtilities;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class WorkerController {

	@Autowired
	WorkerService workerService;

	@GetMapping("/all")
	public Page<Worker> FindAllWorkers(
			  @RequestHeader @Nullable Integer page
			, @RequestHeader @Nullable Integer size
	) {
    if(page==null)page=0;
    if(size==null)size=50;

		return workerService.allWorkers(page,size);
	}

	@PostMapping("/create")
	public ResponseEntity<Worker> createWorker(@RequestBody Worker w1) {
		return workerService.createWorker(w1);
	}

	@GetMapping("/findById/{CI}")
	public ResponseEntity<Worker> findByIdl(@PathVariable long CI) {

		return workerService.findByIdl(CI);
	}

	@PutMapping("update/{CI}")
	public ResponseEntity<Worker> updateWorker(@PathVariable long CI, @RequestBody Worker w2) {
		return workerService.updateWorker(CI, w2);
	}

	@DeleteMapping("delete/{CI}")
	public ResponseEntity<Map<String, Boolean>> deleteWorker(@PathVariable long CI) {

		return workerService.deleteWorker(CI);
	}

	///////////////// filter//////////////////////////////////////////////////////////////



	@Nullable
	@PostMapping("/filterE")
	public List<Worker>filterByE(@RequestBody Worker workerExample
			,@RequestHeader Integer min
			,@RequestHeader Integer max) {
		return workerService.filterE(workerExample,min,max);



	}

	@PostMapping("/filterByCriteria")
	public List<Worker> filterByCriteria(@RequestHeader("criteria") String criteria) {

		return workerService.filterByCriteria(criteria);
	}

	@PostMapping("/filterByNed")
	public List<Worker> filterByNed(@RequestBody Scholarship scholarship) {

		return workerService.filterByNed(scholarship);
	}
	


}
