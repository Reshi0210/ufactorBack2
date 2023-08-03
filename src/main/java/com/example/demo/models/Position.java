package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Data;

@Entity
@Table(name="position")
@Data
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="position_name")
	private String positionName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="category")
	private category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="scale_group_id")
	//@JsonProperty(access = Access.WRITE_ONLY) 
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private ScaleGroup scaleGroup;
	
	


	
	
	
}