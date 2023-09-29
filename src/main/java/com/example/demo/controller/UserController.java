package com.example.demo.controller;


import com.example.demo.models.User;

import com.example.demo.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    JpaUserDetailsService jpaUserDetailsService;


    @GetMapping("/all")
    public List<User> getAll (){
            return jpaUserDetailsService.findAll();}


    @GetMapping("/findById/{id}")
    public User findById (@PathVariable long id){
        return jpaUserDetailsService.findById(id);}

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User u) {
        return jpaUserDetailsService.create(u);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> update(@PathVariable long id, @RequestBody User u2) {
        return jpaUserDetailsService.update(id, u2);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id) {

        return jpaUserDetailsService.delete(id);
    }
}
