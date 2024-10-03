package com.DSI.TP1.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Adresse implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	
	private int NumAppart;
	
	@Column(length=50)
	private String Rue;
	
	@Column(length=50)
	private String Ville;
	
	@Column(length=4)
	private String CodePostal;

	
	
	//les Relations:
	
	@OneToOne(mappedBy="adresse")
	private Etudiant etudiant;
	
	

	public Adresse() {}

    public Adresse(int numAppart, String rue, String ville, String codePostal) {
        this.NumAppart = numAppart;
        this.Rue = rue;
        this.Ville = ville;
        this.CodePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "code=" + code +
                ", Num Appart=" + NumAppart +
                ", Rue='" + Rue + '\'' +
                ", Ville='" + Ville + '\'' +
                ", Code Postal='" + CodePostal + '\'' +
                '}';
    }

	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getNumAppart() {
		return NumAppart;
	}

	public void setNumAppart(int numAppart) {
		NumAppart = numAppart;
	}

	public String getRue() {
		return Rue;
	}

	public void setRue(String rue) {
		Rue = rue;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getCodePostal() {
		return CodePostal;
	}

	public void setCodePostal(String codePostal) {
		CodePostal = codePostal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
