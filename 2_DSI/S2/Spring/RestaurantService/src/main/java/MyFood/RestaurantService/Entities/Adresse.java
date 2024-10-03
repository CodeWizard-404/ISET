package MyFood.RestaurantService.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Adresse implements Serializable{
	
	private static final long serialVersionUID =1L;
	@Id
	private long Numero;
	
	private String Nom;
	
	private String Rue;
	
	private String Cite;
	@Column(name = "ville")
	private String ville;

	public Adresse() {}
	public Adresse(long numero, String nom, String rue, String cite, String ville) {
		super();
		Numero = numero;
		Nom = nom;
		Rue = rue;
		Cite = cite;
		this.ville = ville;
	}

	public long getNumero() {
		return Numero;
	}

	public void setNumero(long numero) {
		Numero = numero;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getRue() {
		return Rue;
	}

	public void setRue(String rue) {
		Rue = rue;
	}

	public String getCite() {
		return Cite;
	}

	public void setCite(String cite) {
		Cite = cite;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Adresse [Numero=" + Numero + ", Nom=" + Nom + ", Rue=" + Rue + ", Cite=" + Cite + ", Ville=" + ville
				+ "]";
	}
	
	

}
