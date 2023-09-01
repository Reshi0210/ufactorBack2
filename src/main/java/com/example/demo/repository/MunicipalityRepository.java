package com.example.demo.repository;

import com.example.demo.models.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MunicipalityRepository extends JpaRepository<Municipality,Long> {

    @Query("select m from Municipality m where m.province.id=:provinceId")
    public List<Municipality> findMunicipalitiesByProvince(@Param("provinceId") Long provinceId);}
