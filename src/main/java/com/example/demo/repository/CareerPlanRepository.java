package com.example.demo.repository;

import com.example.demo.models.CareerPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CareerPlanRepository extends JpaRepository<CareerPlan,Long> {


}
