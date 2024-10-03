package com.DSI.TP1.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
public class Etudiant implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	
	private String nom;
	
	private String prenom;
	

	@Temporal(TemporalType.DATE)
	private LocalDate dateNaissance;
	
	
	
	//les Relations:
	 
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idAdresse")
	private Adresse adresse;
	
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	    name = "emprunt", 
	    joinColumns = @JoinColumn(name = "etudiant_id"), 
	    inverseJoinColumns = @JoinColumn(name = "livre_id")
	)
	private List<Livre> livres ;

	


    public Etudiant() {}

    public Etudiant(String nom, String prenom, LocalDate date, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = date;
        this.adresse = adresse;
        this.livres = new ArrayList<>();
    }
    
    
    
    @Override
    public String toString() {
        return "Etudiant{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date Naissance=" + dateNaissance +
                ", adresse=" + adresse +
                '}';
    }

	
	




public List<Livre> getLivres() {
    return this.livres;
}











	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
