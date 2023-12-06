package com.rihab.excursions.dto;

import java.util.Date;

import com.rihab.excursions.entities.Image;
import com.rihab.excursions.entities.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcursionDTO {
private Long idExcursion;
private String distinationExcursion;
private Double prixExcursion;
private Date dateExcursion;
private String heureDepart;
private String heureRetour;
private String lieuDepart;
private String description;

private Type type;
private String nomType;
 private Image image;
private String ImagePath; 






}