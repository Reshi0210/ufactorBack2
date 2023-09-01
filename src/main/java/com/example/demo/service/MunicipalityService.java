package com.example.demo.service;

import com.example.demo.models.Municipality;
import com.example.demo.models.Province;
import com.example.demo.repository.MunicipalityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MunicipalityService {

    MunicipalityRepository municipalityRepository;


    public List<Municipality> all(Long provinceId){
       return municipalityRepository.findMunicipalitiesByProvince(provinceId);
    }



}
