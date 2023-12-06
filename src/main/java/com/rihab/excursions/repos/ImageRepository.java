package com.rihab.excursions.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.excursions.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
	
}
