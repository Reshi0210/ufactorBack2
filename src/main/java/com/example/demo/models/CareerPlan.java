package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class CareerPlan {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "doctorado_id")
    private Scholarship doctorado;

    @OneToOne
    @JoinColumn(name = "MasterOespecialdiad_id")
    private Scholarship MasterOespecialdiad;

    @OneToOne
    @JoinColumn(name = "posgrado1_id")
    private Scholarship posgrado1;

    @OneToOne
    @JoinColumn(name = "posgrado2_id")
    private  Scholarship posgrado2;

    @OneToOne
    @JoinColumn(name = "formacionPiramida_id")
    private Scholarship formacionPiramidal;

    @OneToOne
    @JoinColumn(name = "IdiomaOptimo")
    private Scholarship IdiomaOptimo;

    @OneToOne
    @JoinColumn(name = "preElementar")
    private Scholarship preElementar;

    @OneToOne
    @JoinColumn(name = "acreditacion")
    private Scholarship acreditacion;

}
