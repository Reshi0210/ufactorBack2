package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.department;


@Repository
public interface DepartmentRepository extends JpaRepository< department, Long> {

}
