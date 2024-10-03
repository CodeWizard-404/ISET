package MyFood.KitchenService.Entities;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Ticket implements Serializable{
	
	private static final long serialVersionUID =1L;
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private KitchenEnum state;
	
	@Temporal(TemporalType.TIME)
	private LocalTime preparingTime;
	
	@Temporal(TemporalType.TIME)
	private LocalTime pickedUpTime;
	
	public Ticket() {}

	public Ticket(KitchenEnum state, LocalTime preparingTime, LocalTime pickedUpTime) {
		super();
		this.state = state;
		this.preparingTime = preparingTime;
		this.pickedUpTime = pickedUpTime;
	}

	public KitchenEnum getState() {
		return state;
	}

	public void setState(KitchenEnum state) {
		this.state = state;
	}

	public LocalTime getPreparingTime() {
		return preparingTime;
	}

	public void setPreparingTime(LocalTime preparingTime) {
		this.preparingTime = preparingTime;
	}

	public LocalTime getPickedUpTime() {
		return pickedUpTime;
	}

	public void setPickedUpTime(LocalTime pickedUpTime) {
		this.pickedUpTime = pickedUpTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", state=" + state + ", preparingTime=" + preparingTime + ", pickedUpTime="
				+ pickedUpTime + "]";
	}
	
	
	
	
	

}
