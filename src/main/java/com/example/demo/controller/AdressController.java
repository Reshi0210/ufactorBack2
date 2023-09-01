package com.example.demo.controller;

import com.example.demo.models.Adress;
import com.example.demo.models.ScaleGroup;
import com.example.demo.service.AdressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/adress")
public class AdressController {

    AdressService adressService;


    @GetMapping("/findById/{id}")
    public Adress findByIdl(@PathVariable long id){

        return adressService.findById(id);
    }


}
