package com.example.demo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="scholarship")
@Data
public class Scholarship {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name="scholar_name")
	private String scholarName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="scholar_level")
	private scholarLevel ScholarLevel;
	
	
	


	
	
	
	

}
