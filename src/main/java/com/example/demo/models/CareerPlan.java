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
    @JoinColumn(name = "Master_id")
    private Scholarship master;

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
    private Scholarship idiomaOptimo;

    @OneToOne
    @JoinColumn(name = "idiomaelemental")
    private Scholarship idiomaelemental;

    @OneToOne
    @JoinColumn(name = "acreditacion")
    private Scholarship acreditacion;

    @OneToOne
    @JoinColumn(name = "doctoradoP_id")
    private Scholarship doctoradoP;

    @OneToOne
    @JoinColumn(name = "MasterP_id")
    private Scholarship masterP;

    @OneToOne
    @JoinColumn(name = "posgrado1P_id")
    private Scholarship posgrado1P;

    @OneToOne
    @JoinColumn(name = "posgrado2P_id")
    private  Scholarship posgrado2P;

    @OneToOne
    @JoinColumn(name = "formacionPiramidaP_id")
    private Scholarship formacionPiramidalP;

    @OneToOne
    @JoinColumn(name = "IdiomaOptimoP")
    private Scholarship idiomaOptimoP;

    @OneToOne
    @JoinColumn(name = "idiomaelementalP")
    private Scholarship idiomaelementalP;

    @OneToOne
    @JoinColumn(name = "acreditacionP")
    private Scholarship acreditacionP;

    @OneToOne
    @JoinColumn(name = "doctoradoF_id")
    private Scholarship doctoradoF;

    @OneToOne
    @JoinColumn(name = "MasterF_id")
    private Scholarship masterF;

    @OneToOne
    @JoinColumn(name = "posgrado1F_id")
    private Scholarship posgrado1F;

    @OneToOne
    @JoinColumn(name = "posgrado2F_id")
    private  Scholarship posgrado2F;

    @OneToOne
    @JoinColumn(name = "formacionPiramidaF_id")
    private Scholarship formacionPiramidalF;

    @OneToOne
    @JoinColumn(name = "IdiomaOptimoF")
    private Scholarship IdiomaOptimoF;

    @OneToOne
    @JoinColumn(name = "idiomaelementalF")
    private Scholarship idiomaelementalF;

    @OneToOne
    @JoinColumn(name = "acreditacionF")
    private Scholarship acreditacionF;

}
