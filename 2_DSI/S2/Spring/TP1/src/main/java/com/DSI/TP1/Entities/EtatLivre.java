package com.DSI.TP1.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class EtatLivre implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	
	private boolean Disponible;
	
	private boolean Emprunté;
	
	
	//les Relations:
	
	@JsonIgnore
	@OneToMany(mappedBy="etatLivre")
	private List<Livre> livres = new ArrayList<>();



    public EtatLivre() {}

    public EtatLivre(boolean disponible, boolean emprunte) {
        this.Disponible = disponible;
        this.Emprunté = emprunte;
    }

    @Override
    public String toString() {
        return "EtatLivre{" +
                "code=" + code +
                ", Disponible=" + Disponible +
                ", Emprunté=" + Emprunté +
                '}';
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isDisponible() {
		return Disponible;
	}

	public void setDisponible(boolean disponible) {
		Disponible = disponible;
	}

	public boolean isEmprunté() {
		return Emprunté;
	}

	public void setEmprunté(boolean emprunté) {
		Emprunté = emprunté;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	



}
