package com.rihab.excursions.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rihab.excursions.entities.Excursion;
import com.rihab.excursions.entities.Image;
import com.rihab.excursions.repos.ExcursionRepository;
import com.rihab.excursions.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	 ImageRepository imageRepository;
	@Autowired
	 ExcursionService excursionService;
	@Autowired
	ExcursionRepository excursionRepository;

	@Override
	 public Image uplaodImage(MultipartFile file) throws IOException {
	 /*Ce code commenté est équivalent au code utilisant le design pattern Builder
	 * Image image = new Image(null, file.getOriginalFilename(),
	 file.getContentType(), file.getBytes(), null);
	 return imageRepository.save(image);*/
		
		
	 return imageRepository.save(Image.builder()
	 .name(file.getOriginalFilename())
	 .type(file.getContentType())
	 .image(file.getBytes())
	.build() );
	 }
	 @Override
	public Image getImageDetails(Long id) throws IOException{
	 final Optional<Image> dbImage = imageRepository. findById (id);
	 return Image.builder()
	 .idImage(dbImage.get().getIdImage())
	 .name(dbImage.get().getName())
	 .type(dbImage.get().getType())
	 .image(dbImage.get().getImage()).build() ;
	 }
	 @Override
 public ResponseEntity<byte[]> getImage(Long id) throws IOException{
	 final Optional<Image> dbImage = imageRepository. findById (id);
	 return ResponseEntity
	 .ok()
	 .contentType(MediaType.valueOf(dbImage.get().getType()))
	 .body(dbImage.get().getImage());
	 }
	 @Override
 public void deleteImage(Long id) {
	 imageRepository.deleteById(id);
	 }
/*
		@Override
		public Image uplaodImageEx(MultipartFile file, Long idEx) throws IOException {
			Excursion e = new Excursion();
			e.setIdExcursion(idEx);
			return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
					.image(file.getBytes()).excursion(e).build());
		}
	 
	
		@Override
		public List<Image> getImagesParEx(Long exId) {
			Excursion e = excursionRepository.findById(exId).get();
		return e.getImages();
		}
	
	*/
}
		