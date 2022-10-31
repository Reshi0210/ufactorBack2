package com.example.demo.models;

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
public class Scholarship {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name="scholar_name")
	private String scholarName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="scholar_level")
	private scholarLevel ScholarLevel;
	
	
	

	public Scholarship() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getScholarName() {
		return scholarName;
	}

	public void setScholarName(String scholarName) {
		this.scholarName = scholarName;
	}

	public scholarLevel getScholarLevel() {
		return ScholarLevel;
	}

	public void setScholarLevel(scholarLevel scholarLevel) {
		ScholarLevel = scholarLevel;
	}
	
	
	
	

}
