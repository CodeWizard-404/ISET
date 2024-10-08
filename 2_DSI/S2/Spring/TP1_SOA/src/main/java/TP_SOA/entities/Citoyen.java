package TP_SOA.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Citoyen {
	@Id
	private String cin;
	private String name;
	private String prenom;
	private LocalDate dateDeNaissance;
	
	public Citoyen(String cin, String name, String prenom, LocalDate dateDeNaissance) {
		super();
		this.cin = cin;
		this.name = name;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
	}
	
	public Citoyen() {
		super();
	}

	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	@Override
	public String toString() {
		return "Citoyen [cin=" + cin + ", name=" + name + ", prenom=" + prenom + "]";
	}
	
	
	
	
}
