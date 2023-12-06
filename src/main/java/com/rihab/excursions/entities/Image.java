package com.rihab.excursions.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;


@Entity
@Builder // creation des objets complexes 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idImage ;
 private String name ;
 private String type ;
 @Column( name = "IMAGE" , length = 4048576 )// length pas de tiny lob 
 @Lob
 private byte[] image;// tab de byte d'octet : @lob: type lop : type binaire
 //@ManyToOne
 @OneToOne
 @JoinColumn (name="EXCURSION_ID")
 @JsonIgnore
private Excursion excursion;

}