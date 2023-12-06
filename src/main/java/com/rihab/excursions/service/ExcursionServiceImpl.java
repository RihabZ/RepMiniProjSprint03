package com.rihab.excursions.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.excursions.dto.ExcursionDTO;
import com.rihab.excursions.entities.Excursion;
import com.rihab.excursions.entities.Type;
import com.rihab.excursions.repos.ExcursionRepository;
import com.rihab.excursions.repos.ImageRepository;
@Service
public class ExcursionServiceImpl implements ExcursionService {
@Autowired
ExcursionRepository excursionRepository;

@Autowired
ModelMapper modelMapper;

@Autowired
ImageRepository imageRepository ;

@Override
public ExcursionDTO saveExcursion(ExcursionDTO e) {
	
	return convertEntityToDto(excursionRepository.save(convertDtoToEntity(e)));
	}
/*
	@Override
	public Excursion updateExcursion(Excursion e) {
		//Long oldExImageId = this.getExcursion(e.getIdExcursion()).getImage().getIdImage();
		//Long newExImageId = e.getImage().getIdImage();
		Excursion exUpdated = excursionRepository.save(e);
		//if (oldExImageId != newExImageId) // si l'image a été modifiée
			//imageRepository.deleteById(oldExImageId);
		return exUpdated;
	}
	*/
	/*
public ExcursionDTO updateExcursion(ExcursionDTO e) {
    Long oldExImageId = this.getExcursion(e.getIdExcursion()).getImage().getIdImage();
    Long newExImageId = e.getImage().getIdImage();
    Excursion exUpdated = excursionRepository.save(convertDtoToEntity(e));

    if (!oldExImageId.equals(newExImageId)) { // Utilisez equals pour comparer les Long
        imageRepository.deleteById(oldExImageId);
    }

    return convertEntityToDto(exUpdated);
}
*/


@Override
public ExcursionDTO updateExcursion(ExcursionDTO e) {
	return convertEntityToDto(excursionRepository.save(convertDtoToEntity(e)));
}
	@Override
	public void deleteExcursion(Excursion e) {
		excursionRepository.delete(e);
	}
	/*
	 @Override
	public void deleteExcursionById(Long id) {
		 // supprimer l'image avant de supprimer l excursion
		ExcursionDTO p =getExcursion(id);
		//suuprimer l'image avant de supprimer le produit
		try {
		Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
		} catch (IOException e) {
		e.printStackTrace();
		}
	
		
		
		 excursionRepository.deleteById(id);
	}
	*/ // fas5tha twaa
	

@Override
public void deleteExcursionById(Long id) {
	 excursionRepository.deleteById(id);
}
	
	
	@Override
	public ExcursionDTO getExcursion(Long id) {
	return convertEntityToDto(excursionRepository.findById(id).get());
	}
	@Override
	public List<ExcursionDTO> getAllExcursions() {
		return excursionRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
		}
	
	
	@Override
	public List<Excursion> findByDistinationExcursion(String distination) {
	return excursionRepository.findByDistinationExcursion(distination);
	}
	@Override
	public List<Excursion> findByDistinationExcursionContains(String distination) {
	return excursionRepository.findByDistinationExcursionContains(distination);
	}
	@Override
	public List<Excursion> findByDistinationPrix(String distination, Double prix) {
	return excursionRepository.findByNomPrix(distination, prix);
	}
	@Override
	public List<Excursion> findByType(Type type) {
	return excursionRepository.findByType(type);
	}
	@Override
	public List<Excursion> findByTypeIdType(Long id) {
	return excursionRepository.findByTypeIdType(id);
	}
	@Override
	public List<Excursion> findByOrderByDistinationExcursionAsc() {
	return excursionRepository.findByOrderByDistinationExcursionAsc();
	}
	@Override
	public List<Excursion> trierExcursionsDistinationsPrix() {
	return excursionRepository.trierExcursionsDistinationsPrix();
	}
	
	
	@Override
	public ExcursionDTO convertEntityToDto(Excursion excursion) {
		
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ExcursionDTO excursionDTO =  modelMapper.map(excursion, ExcursionDTO.class);
	/*	
		excursionDTO.setIdExcursion(excursion.getIdExcursion());
		excursionDTO.setDistinationExcursion(excursion.getDistinationExcursion());
		//excursionDTO.setPrixExcursion(excursion.getPrixExcursion());
		excursionDTO.setDateExcursion(excursion.getDateExcursion());
		//excursionDTO.setType(excursion.getType());
	//excursionDTO.setNomType(excursion.getType().getNomType());
		excursionDTO.setHeureDepart(excursion.getHeureDepart()); 
		excursionDTO.setHeureRetour(excursion.getHeureRetour());
		excursionDTO.setLieuDepart(excursion.getLieuDepart());
		excursionDTO.setDescription(excursion.getDescription());
	*/	
		return excursionDTO; 
	
		
	}
		@Override
		public Excursion convertDtoToEntity(ExcursionDTO excursionDTO) {
			Excursion excursion = new Excursion();
			excursion = modelMapper.map(excursionDTO, Excursion.class);
			/*
			excursion.setIdExcursion(excursionDTO.getIdExcursion());
			excursion.setDistinationExcursion(excursionDTO.getDistinationExcursion());
			excursion.setPrixExcursion(excursionDTO.getPrixExcursion());
			excursion.setDateExcursion(excursionDTO.getDateExcursion());
			excursion.setType(excursionDTO.getType());
			//excursion.setNomType(excursion.getType().getNomType());
			excursion.setHeureDepart(excursionDTO.getHeureDepart()); 
			excursion.setHeureRetour(excursionDTO.getHeureRetour());
			excursion.setLieuDepart(excursionDTO.getLieuDepart());
			excursion.setDescription(excursionDTO.getDescription());
			*/
			return excursion; 
		}
		
		

	
	
		/*@Override
		public ExcursionDTO updateExcursionFromDTO(ExcursionDTO excursionDTO) {
		  //  Excursion existingExcursion = getExcursionById(excursionDTO.getIdExcursion()); // Implémentez getExcursionById
		    if (existingExcursion != null) {
		        Excursion updatedExcursion = convertDtoToEntity(excursionDTO);
		        updatedExcursion = excursionRepository.save(updatedExcursion);
		        return convertEntityToDto(updatedExcursion);
		    } else {
		        return null; // Indique que l'excursion n'a pas été trouvée
		    }
		}
*/
			
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}