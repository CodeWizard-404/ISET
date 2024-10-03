package MyFood.CourtierService.Entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "couriers")
public class Courier implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "cin")
    private String cin;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_available")
    private boolean isAvailable;

    @OneToOne(mappedBy = "courier", cascade = CascadeType.ALL)
    private Location location;

	public Courier(Long id, String cin, String name, String phone, boolean isAvailable, Location location) {
		super();
		this.id = id;
		this.cin = cin;
		this.name = name;
		this.phone = phone;
		this.isAvailable = isAvailable;
		this.location = location;
	}
	
	public Courier() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Courier [id=" + id + ", cin=" + cin + ", name=" + name + ", phone=" + phone + ", isAvailable="
				+ isAvailable + ", location=" + location + "]";
	}

    
}
