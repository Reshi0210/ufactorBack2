package com.example.demo.controller;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
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
import com.example.demo.models.Worker;
import com.example.demo.models.contractType;
import com.example.demo.models.defensePlace;
import com.example.demo.models.race;
import com.example.demo.models.sex;
import com.example.demo.service.WorkerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class WorkerController {
	
	@Autowired
	WorkerService workerService;

	
	@GetMapping("/all")
	public List<Worker> FindAllWorkers(){
		
		return workerService.allWorkers();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Worker> createWorker(@RequestBody Worker w1) {
		return workerService.createWorker( w1);
	}
    
	@GetMapping("/findById/{CI}")
	public ResponseEntity<Worker> findByIdl(@PathVariable long CI){
		
	return workerService.findByIdl(CI);
	}
	
	@PutMapping("update/{CI}")
	public ResponseEntity<Worker> updateWorker(@PathVariable long CI,@RequestBody Worker w2){
		return workerService.updateWorker(CI, w2);
	}
	
	@DeleteMapping("delete/{CI}")
	public  ResponseEntity<Map<String,Boolean>> deleteWorker(@PathVariable long CI) {
		
		return workerService.deleteWorker(CI);
	}
	
	
	/////////////////filter//////////////////////////////////////////////////////////////
	
	@GetMapping("/filter")
	public List<Worker> Filter(@RequestParam ("firstName") String firstName){
		
		return workerService.filter(firstName);}
	
	@GetMapping("/filterS")
	public List<Worker> FilterS(@RequestParam ("sex") sex sex){
		
		return workerService.filterS(sex);}
	
	@Nullable
	@GetMapping("/fil")
	public List<Worker> Fil(@RequestParam ("sex") @Nullable sex sex,
			@RequestParam("race") @Nullable  race race,
			@RequestParam("depa") @Nullable  String depa,
	        @RequestParam("contractType") @Nullable contractType  contractType,
	        @RequestParam("defensePlace") @Nullable defensePlace  defensePlace)
	       
	{
	
		return workerService.fil(sex,race,depa,contractType,defensePlace);}
	
	
	@Nullable
	@PostMapping("/filterByExample")
	public List<Worker> filterByExample(@RequestBody Worker worker){
		
		return workerService.filterByExample(worker);
		
		
		
		
	}
	@Nullable
	@GetMapping("/f")
	public List<Worker> filterSecondName(@RequestParam("secondName") String secondName){
		
		
		return workerService.findBySecondName(secondName);
	}
	
	@Nullable
	@PostMapping("/filterE")
	public List<Worker> filterByE(@RequestBody Worker worker,  @RequestHeader  ("level") @Nullable String level){
		
		
		return workerService.filterE(worker,level);
	
}    
	@PostMapping("/filterByCriteria")
	public List<Worker> filterByCriteria(@RequestHeader ("criteria")  String criteria){
		
		return workerService.filterByCriteria(criteria);
	}
	
	
	}

