package com.example.demo.service;

import com.example.demo.models.Entidad;
import com.example.demo.repository.EntidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntidadService {

    EntidadRepository entidadRepository;

    public List<Entidad> getAll(){
        return  entidadRepository.findAll();
    }
}
