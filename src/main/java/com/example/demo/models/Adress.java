package com.example.demo.models;

import lombok.Data;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Table(name="Adresss")
@Data
public class Adress  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="province_id")
    private Province province;

    @OneToOne
    @JoinColumn(name="municiplaity_id")
    private Municipality municipality;



    private String street;

    private String  avenue;

    private String  numberOrPlace;
}
