package com.rihab.excursions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rihab.excursions.dto.ExcursionDTO;
import com.rihab.excursions.entities.Excursion;
import com.rihab.excursions.entities.Type;

@RepositoryRestResource(path = "rest")
public interface ExcursionRepository extends JpaRepository<Excursion,Long> {
	
	List<Excursion> findByDistinationExcursion(String distination);
	 List<Excursion> findByDistinationExcursionContains(String distination);
	
	 @Query("select e from Excursion e where e.distinationExcursion like %?1 and e.prixExcursion > ?2")
	 List<Excursion> findByDistinationPrix (String distination, Double prix);

	 @Query("select e from Excursion e where e.distinationExcursion like %:distination and e.prixExcursion > :prix")
	 List<Excursion> findByNomPrix (@Param("distination") String nom,@Param("prix") Double prix);
	 
	 @Query("select e from Excursion e where e.type = ?1")
	 List<Excursion> findByType (Type type); 
	 
	 List<Excursion> findByTypeIdType(Long id);

	 List<Excursion> findByOrderByDistinationExcursionAsc();
	 
	 @Query("select e from Excursion e order by e.distinationExcursion ASC, e.prixExcursion DESC")
	 List<Excursion> trierExcursionsDistinationsPrix ();
	ExcursionDTO save(ExcursionDTO e);

	 
}
