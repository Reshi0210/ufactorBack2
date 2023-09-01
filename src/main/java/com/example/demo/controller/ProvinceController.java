package com.example.demo.controller;

import com.example.demo.models.Province;
import com.example.demo.service.ProvinceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/province")
public class ProvinceController {

    ProvinceService provinceService;

    @GetMapping("/all")
    public List<Province> finAll(){
        return provinceService.findAll();
    }
}
