package com.rihab.excursions.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.rihab.excursions.dto.ExcursionDTO;
import com.rihab.excursions.entities.Excursion;
import com.rihab.excursions.entities.Image;
import com.rihab.excursions.service.ExcursionService;
import com.rihab.excursions.service.ImageService;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {

	
	@Autowired
	 ImageService imageService ;
	@Autowired
	ExcursionService excursionService;


	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		 		return imageService.uplaodImage(file);
	 }
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		 		return imageService.getImageDetails(id) ;
	 }
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
	{
		 			return imageService.getImage(id);
	 }


	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
		 		imageService.deleteImage(id);
	 }
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
		 			return imageService.uplaodImage(file);
	 }
	 
	/*
	 @PostMapping(value = "/uplaodImageEx/{idEx}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
	 @PathVariable("idEx") Long idEx)
	throws IOException {
	 return imageService.uplaodImageEx(file,idEx);
	 }
	 
	@RequestMapping(value = "/getImagesEx/{idEx}" ,
	 method = RequestMethod.GET)
	 public List<Image> getImagesEx(@PathVariable("idEx") Long idEx)
	throws IOException {
	 return imageService.getImagesParEx(idEx);
	 }
*/
/*
	@RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
	public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id) throws IOException {
	    ExcursionDTO e = excursionService.getExcursion(id);
	    e.setImagePath(id + ".jpg");

	    Files.write(Paths.get(System.getProperty("user.home") + "/images/" + e.getImagePath()), file.getBytes());
	    excursionService.saveExcursion(e);
	}

	@RequestMapping(value = "/loadfromFS/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

	    ExcursionDTO e = excursionService.getExcursion(id);
	    byte[] imageBytes = Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/images/" + e.getImagePath()));
	    
	  return
	    Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+e.getImagePath()));
	}
*/

	
}