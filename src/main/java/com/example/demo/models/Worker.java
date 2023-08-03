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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import utilities.AgeUtilities;

@Entity
@Table
@Data
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "age")
	private Integer age;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "second_name")
	private String secondName;

	@Column(name = "last_name")
	private String lastName;
    
	
	@Column(name = "ci",unique=true)
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
	
	@Enumerated(EnumType.STRING)
	@Column(name="active")
	private active active;

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

	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name = "scholarShip_id")
	// @JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Scholarship scholarShip ;









	
	
	
	

}
