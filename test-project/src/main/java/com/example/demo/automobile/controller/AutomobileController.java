package com.example.demo.automobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.automobile.entity.Automobile;
import com.example.demo.automobile.repository.AutomobileRepository;
import com.example.demo.automobile.service.AutomobileService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/automobile")
public class AutomobileController {
	
	@Autowired
	private AutomobileService automobileService;
	
	@GetMapping("/getall")
	public List<Automobile> getAll() {
		return automobileService.getAllAutomobilies();
	}
	
	@GetMapping("/getbymarca")
	public List<Automobile> getByMarca(String marca) {
		return automobileService.getAutomobileByMarca(marca);
	}
	
	@PostMapping("/add")
	public void addAuto(@RequestBody Automobile automobile) {
		automobileService.addAutomobile(automobile);
	}

}
