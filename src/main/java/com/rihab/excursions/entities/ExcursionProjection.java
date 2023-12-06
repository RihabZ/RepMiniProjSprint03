package com.rihab.excursions.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "distinationEx", types = { Excursion.class })
public interface ExcursionProjection 
{
public String getDistinationExcursion();
}