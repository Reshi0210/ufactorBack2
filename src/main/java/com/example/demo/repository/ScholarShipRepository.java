package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Scholarship;

public interface ScholarShipRepository extends JpaRepository<Scholarship, Long> {

}
