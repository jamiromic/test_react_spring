package com.example.demo.automobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.automobile.entity.Automobile;
import com.example.demo.automobile.repository.AutomobileRepository;

@Service
public class AutomobileService {
	
	private final AutomobileRepository automobileRepository;
	
	@Autowired
    public AutomobileService(AutomobileRepository automobileRepository) {
        this.automobileRepository = automobileRepository;
    }
	
	public List<Automobile> getAllAutomobilies() {
		return automobileRepository.findAll();
	}

	public List<Automobile> getAutomobileByMarca(String marca) {
		return automobileRepository.findByMarca(marca);
	}
	
	public void addAutomobile(Automobile automobile) {
		Automobile newAutomobile = new Automobile();
		newAutomobile.setMarca(automobile.getMarca());
		newAutomobile.setAlimentazione(automobile.getAlimentazione());
		newAutomobile.setColore(automobile.getColore());
		newAutomobile.setAnnoImmatricolazione(automobile.getAnnoImmatricolazione());
		automobileRepository.save(newAutomobile);
	}

}
