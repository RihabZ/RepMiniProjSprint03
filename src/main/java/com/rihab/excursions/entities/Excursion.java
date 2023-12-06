package com.rihab.excursions.entities;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Excursion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExcursion;
	
	private String distinationExcursion;
	private Double prixExcursion;
	private Date dateExcursion;
	private String heureDepart;
	private String heureRetour;
	private String lieuDepart;
	private String description;
	
	@ManyToOne
	private Type type;
	
	@OneToOne
	private Image image;
	
	// @OneToMany (mappedBy = "excursion")
	// private List<Image> images;

	 //private String imagePath;
	 
	 
	 
	 
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Excursion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Excursion(String distinationExcursion, Double prixExcursion, Date dateExcursion, String heureDepart,
			String heureRetour, String lieuDepart, String description) {
		super();
		this.distinationExcursion = distinationExcursion;
		this.prixExcursion = prixExcursion;
		this.dateExcursion = dateExcursion;
		this.heureDepart = heureDepart;
		this.heureRetour = heureRetour;
		this.lieuDepart = lieuDepart;
		this.description = description;
	}
	public Long getIdExcursion() {
		return idExcursion;
	}
	public void setIdExcursion(Long idExcursion) {
		this.idExcursion = idExcursion;
	}
	public String getDistinationExcursion() {
		return distinationExcursion;
	}
	public void setDistinationExcursion(String distinationExcursion) {
		this.distinationExcursion = distinationExcursion;
	}
	public Double getPrixExcursion() {
		return prixExcursion;
	}
	public void setPrixExcursion(Double prixExcursion) {
		this.prixExcursion = prixExcursion;
	}
	public Date getDateExcursion() {
		return dateExcursion;
	}
	public void setDateExcursion(Date dateExcursion) {
		this.dateExcursion = dateExcursion;
	}
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getHeureRetour() {
		return heureRetour;
	}
	public void setHeureRetour(String heureRetour) {
		this.heureRetour = heureRetour;
	}
	public String getLieuDepart() {
		return lieuDepart;
	}
	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Excursion [idExcursion=" + idExcursion + ", distinationExcursion=" + distinationExcursion
				+ ", prixExcursion=" + prixExcursion + ", dateExcursion=" + dateExcursion + ", heureDepart="
				+ heureDepart + ", heureRetour=" + heureRetour + ", lieuDepart=" + lieuDepart + ", description="
				+ description + "]";
	}
	/*
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	

	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
		*/
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

	
	
	
}
