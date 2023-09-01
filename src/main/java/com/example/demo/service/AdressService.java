package com.example.demo.service;


import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Adress;
import com.example.demo.repository.AdressRepository;
import com.nimbusds.openid.connect.sdk.claims.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdressService {

    AdressRepository adressRepository;

    public Adress findById(Long id){

        return adressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Missmatch error"));
    }



}
