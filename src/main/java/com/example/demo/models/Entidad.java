package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Entidad {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
