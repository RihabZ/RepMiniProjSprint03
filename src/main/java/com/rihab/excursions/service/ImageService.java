package com.rihab.excursions.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.rihab.excursions.entities.Image;

public interface ImageService {

	Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id) ;
	 
	 //Image uplaodImageEx(MultipartFile file,Long idEx) throws IOException;
	// List<Image> getImagesParEx(Long exId);
}
