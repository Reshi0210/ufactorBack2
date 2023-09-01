package com.example.demo.service;

import com.example.demo.models.Province;
import com.example.demo.repository.ProvinceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProvinceService {

    ProvinceRepository provinceRepository;

    public List<Province> findAll(){
        return provinceRepository.findAll();
    }
}
