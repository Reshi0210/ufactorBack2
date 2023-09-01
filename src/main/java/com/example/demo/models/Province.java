package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table
@Data
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;





}
