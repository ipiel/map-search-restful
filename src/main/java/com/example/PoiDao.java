package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PoiDao extends JpaRepository <Poi, Integer> {
	
}