package com.example.demo.controller;

import com.example.demo.models.Entidad;
import com.example.demo.service.EntidadService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/entidades")
public class EntidadController {

    EntidadService entidadService;

    @GetMapping("/all")
    public List<Entidad> getAll(){
        return  entidadService.getAll();
    }
}
