package MyFood.KitchenService.Entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LineItems implements Serializable{
	
	private static final long serialVersionUID =1L;
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int quantite;
	
	private int idMenu;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTicket")
	private Ticket idTicket;

	public LineItems(int quantite, int idMenu, Ticket idTicket) {
		super();
		this.quantite = quantite;
		this.idMenu = idMenu;
		this.idTicket = idTicket;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public Ticket getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Ticket idTicket) {
		this.idTicket = idTicket;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "LineItems [id=" + id + ", quantite=" + quantite + ", idMenu=" + idMenu + ", idTicket=" + idTicket + "]";
	}
	
	
	

}
