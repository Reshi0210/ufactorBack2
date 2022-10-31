package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "second_name")
	private String secondName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "ci")
	private String ci;

	@Column(name = "expedient_number")
	private String expedientNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "sex")
	private sex sex;

	@Enumerated(EnumType.STRING)
	@Column(name = "race")
	private race race;

	@Enumerated(EnumType.STRING)
	@Column(name = "contract_type")
	private contractType contractType;

	@Enumerated(EnumType.STRING)
	@Column(name = "defense_place")
	private defensePlace defensePlace;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "department_id")
	// @JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private department department;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "position_id")
	// @JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Position position;

	@ManyToMany(fetch = FetchType.LAZY )
	@JoinTable(name = "worker_scholarship", 
	joinColumns = @JoinColumn(name = "worker_id"), 
	inverseJoinColumns = @JoinColumn(name = "scholarship_id"))
	private Set<Scholarship> scholarShiplist = new HashSet<>();
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "worker_politicintegration", 
	joinColumns = @JoinColumn(name = "worker_id"), 
	inverseJoinColumns = @JoinColumn(name = "politicintegration_id"))
	private Set<PoliticIntegration> politiclist = new HashSet<>();

	public Worker() {
	}
	
	

	public Set<Scholarship> getScholarShiplist() {
		return scholarShiplist;
	}



	public void setScholarShiplist(Set<Scholarship> scholarShiplist) {
		this.scholarShiplist = scholarShiplist;
	}



	public Set<PoliticIntegration> getPoliticlist() {
		return politiclist;
	}

	public void setPoliticlist(Set<PoliticIntegration> politiclist) {
		this.politiclist = politiclist;
	}



	

	public defensePlace getDefensePlace() {
		return defensePlace;
	}



	public void setDefensePlace(defensePlace defensePlace) {
		this.defensePlace = defensePlace;
	}



	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public department getDepartment() {
		return department;
	}

	public void setDepartment(department department) {
		this.department = department;
	}

	public race getRace() {
		return race;
	}

	public void setRace(race race) {
		this.race = race;
	}

	public contractType getContractType() {
		return contractType;
	}

	public void setContractType(contractType contractType) {
		this.contractType = contractType;
	}

	public sex getSex() {
		return sex;
	}

	public void setSex(sex sex) {
		this.sex = sex;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getExpedientNumber() {
		return expedientNumber;
	}

	public void setExpedientNumber(String expedientNumber) {
		this.expedientNumber = expedientNumber;
	}
	
	

}
