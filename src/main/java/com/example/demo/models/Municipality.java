package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="province_id")
    private Province province;


}

