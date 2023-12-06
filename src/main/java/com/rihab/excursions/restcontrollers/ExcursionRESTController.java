package com.rihab.excursions.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rihab.excursions.dto.ExcursionDTO;
import com.rihab.excursions.entities.Excursion;
import com.rihab.excursions.service.ExcursionService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ExcursionRESTController {
@Autowired
ExcursionService excursionService;
@RequestMapping(path ="all", method = RequestMethod.GET)
public List<ExcursionDTO> getAllExcursions() {
return excursionService.getAllExcursions();
}


@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
public ExcursionDTO getExcursionById(@PathVariable("id") Long id) {
return excursionService.getExcursion(id);
 }


@RequestMapping(path="/addex",method= RequestMethod.POST)
public ExcursionDTO createExcursion(@RequestBody ExcursionDTO excursionDTO) {
	//System.out.println("hhhhhhhhhhhhhhhhh");
	return excursionService.saveExcursion(excursionDTO);
}

@RequestMapping(path="/updateex",method = RequestMethod.PUT)
public ExcursionDTO updateExcursion(@RequestBody ExcursionDTO excursionDTO) {
return excursionService.updateExcursion(excursionDTO);
}

@RequestMapping(value="/delex/{id}",method = RequestMethod.DELETE)
public void deleteExcursion(@PathVariable("id") Long id)
{
	excursionService.deleteExcursionById(id);
}

@RequestMapping(value="/exstype/{idType}",method = RequestMethod.GET)
public List<Excursion> getExcursionsByTypeId(@PathVariable("idType") Long idType) {
return excursionService.findByTypeIdType(idType);
}

@RequestMapping(value="/exsByDistination/{distination}",method = RequestMethod.GET)
public List<Excursion> findByDistinationExcursionContains(@PathVariable("distination") String distination) {
	System.out.println("hhhhh");
return excursionService.findByDistinationExcursionContains(distination);
}
}