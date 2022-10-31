package com.example.demo.models;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="departament_name")
	private String departamentName;
	
	//@OneToMany(mappedBy = "department")
	//private Set<Worker> workers; 
	
	

	public department() {
	}

	//public Set<Worker> getWorkers() {
		//return workers;
	//}

	//public void setWorkers(Set<Worker> workers) {
		//workers.stream().forEach((worker)->worker.setDepartment(this));
		//this.workers = workers;
		
	//}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartamentName() {
		return departamentName;
	}

	public void setDepartamentName(String departamentName) {
		this.departamentName = departamentName;
	}

}
