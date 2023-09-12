package com.example.demo.repository;

import com.example.demo.models.scholarLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Scholarship;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScholarShipRepository extends JpaRepository<Scholarship, Long> {

    @Query("Select s from Scholarship s where s.ScholarLevel=:level")
    public List<Scholarship> findScholarshipByScholarLevel(@Param("level") scholarLevel level);

}
