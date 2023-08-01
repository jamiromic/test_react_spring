package com.example.demo.automobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.automobile.entity.Automobile;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, Long> {
	
	List<Automobile> findByMarca(String marca);

}
