package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String role;


}
