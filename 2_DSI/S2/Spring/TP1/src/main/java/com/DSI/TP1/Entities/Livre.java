package com.DSI.TP1.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="livre_biblio")
public class Livre implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="code")
	private int code;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="titre_livre")
	private String titre_livre;
	
	@Column(name="auteur_livre",length=40)
	private String auteur_livre;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_publication")
	private LocalDate date_publication;
	
	@Column(name="nb_copies")
	private int nb_copies;
	
	
	//les Relations:
	
	@ManyToOne
	@JoinColumn(name="idEtat")
	private EtatLivre etatLivre;

	@JsonIgnore
	@ManyToMany(mappedBy = "livres")
	private List<Etudiant> etudiants;



    public Livre() {}

    public Livre(String isbn, String titreLivre, String auteurLivre, LocalDate datePublication, int nbCopies) {
        this.isbn = isbn;
        this.titre_livre = titreLivre;
        this.auteur_livre = auteurLivre;
        this.date_publication = datePublication;
        this.nb_copies = nbCopies;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "code=" + code +
                ", ISBN='" + isbn + '\'' +
                ", Titre='" + titre_livre + '\'' +
                ", Auteur='" + auteur_livre + '\'' +
                ", Date Pub=" + date_publication +
                ", NB copies=" + nb_copies +
                "}\n";
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre_livre() {
		return titre_livre;
	}

	public void setTitre_livre(String titre_livre) {
		this.titre_livre = titre_livre;
	}

	public String getAuteur_livre() {
		return auteur_livre;
	}

	public void setAuteur_livre(String auteur_livre) {
		this.auteur_livre = auteur_livre;
	}

	public LocalDate getDate_publication() {
		return date_publication;
	}

	public void setDate_publication(LocalDate date_publication) {
		this.date_publication = date_publication;
	}

	public int getNb_copies() {
		return nb_copies;
	}

	public void setNb_copies(int nb_copies) {
		this.nb_copies = nb_copies;
	}

	public EtatLivre getEtatLivre() {
		return etatLivre;
	}

	public void setEtatLivre(EtatLivre etatLivre) {
		this.etatLivre = etatLivre;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	
	
	

}
