package com.rihab.excursions.service;
import java.util.List;

import com.rihab.excursions.dto.ExcursionDTO;
import com.rihab.excursions.entities.Excursion;
import com.rihab.excursions.entities.Type;
public interface ExcursionService {
	ExcursionDTO saveExcursion(ExcursionDTO e);
	ExcursionDTO updateExcursion(ExcursionDTO e) ;
void deleteExcursion(Excursion e);
 void deleteExcursionById(Long id);
 ExcursionDTO getExcursion(Long id);
List<ExcursionDTO> getAllExcursions();

List<Excursion> findByDistinationExcursion(String nom);
List<Excursion> findByDistinationExcursionContains(String distination);
List<Excursion> findByDistinationPrix (String nom, Double prix);
List<Excursion> findByType (Type type);
List<Excursion> findByTypeIdType(Long id);
List<Excursion> findByOrderByDistinationExcursionAsc();
List<Excursion> trierExcursionsDistinationsPrix();
ExcursionDTO convertEntityToDto (Excursion excursion);

Excursion convertDtoToEntity(ExcursionDTO excursionDTO);
//Excursion updateExcursion(Excursion e);





}


