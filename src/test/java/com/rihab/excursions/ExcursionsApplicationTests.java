package com.rihab.excursions;
import java.util.Date;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rihab.excursions.entities.Excursion;
import com.rihab.excursions.entities.Type;
import com.rihab.excursions.repos.ExcursionRepository;
@SpringBootTest
class ExcursionsApplicationTests {

	@Autowired
	private ExcursionRepository excursionRepository;
	@Test
	public void testCreateExcursion() {
		Excursion ex = new Excursion("Binzart", 65.5 ,new Date(),"6h","20h","Rond Point Bhar","Sport et danse sur mer y compris repat");
		excursionRepository.save(ex);
	}
	
	
	@Test
	public void testFindExcursion()
	{
		Excursion e = excursionRepository.findById(1L).get();
	System.out.println(e);
	}
	@Test
	public void testUpdateExcursion()
	{
		Excursion e = excursionRepository.findById(1L).get();
	e.setPrixExcursion(45.0);
	excursionRepository.save(e);
	}
	
	@Test
	public void testDeleteExcursion()
	{
		excursionRepository.deleteById(2L);;
	}

	@Test
	public void testListerTousExcursions()
	{
	List<Excursion> exs = excursionRepository.findAll();
	for (Excursion e : exs)
	{
	System.out.println(e);
	}
	}
	
	
	@Test
	public void testFindByDistinationExcursion()
	{
	List<Excursion> exs = excursionRepository.findByDistinationExcursion("Binzart");
	for (Excursion e : exs)
	{
	System.out.println(e);
	}
	}
	
	
	@Test
	public void testFindByDDistinationExcursionContains ()
	{
	List<Excursion> exs=excursionRepository.findByDistinationExcursionContains("Ain");
	for (Excursion e : exs)
	{
	System.out.println(e);
	} }
	
	@Test
	public void testfindByDistinationPrix()
	{
	List<Excursion> exs = excursionRepository.findByDistinationPrix("Binzart", 65.5);
	for (Excursion e : exs)
	{
	System.out.println(e);
	}
	}
	
	
	
	@Test
	public void testfindByType()
	{
	Type typ = new Type();
	typ.setIdType(1L);
	List<Excursion> exs = excursionRepository.findByType(typ);
	for (Excursion e : exs)
	{
	System.out.println(e);
	}
	}
		
	@Test
	public void findByTypeIdType()
	{
	List<Excursion> exs = excursionRepository.findByTypeIdType(1L);
	for (Excursion e: exs)
	{
	System.out.println(e);
	}
	 }
	@Test
	public void testfindByOrderByDistinationExcursionAsc()
	{
	List<Excursion> exs =excursionRepository.findByOrderByDistinationExcursionAsc();
	for (Excursion e : exs)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testTrierExcursionsDistinationsPrix()
	{
	List<Excursion> exs = excursionRepository.trierExcursionsDistinationsPrix();
	for (Excursion e : exs)
	{
	System.out.println(e);
	}
	}
	
	}
