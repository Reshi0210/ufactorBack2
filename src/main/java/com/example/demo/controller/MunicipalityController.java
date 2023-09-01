package com.example.demo.controller;

import com.example.demo.models.Municipality;
import com.example.demo.models.Position;
import com.example.demo.service.MunicipalityService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/municipality")
public class MunicipalityController {

    MunicipalityService municipalityService;


    @GetMapping("/all/{provinceId}")
    public List<Municipality> FindAll(@PathVariable("provinceId") Long provinceId){

        return municipalityService.all(provinceId);
    }
}
