package com.example.demo.repository;

import com.example.demo.models.Adress;
import com.example.demo.models.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdressRepository extends JpaRepository<Adress, Long> {

}