package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class TestController {
	
	

		

		@RequestMapping("")
		public String hello() {

			return "<h1> hello Eastoy funcionando  <h1>";
		}

}
