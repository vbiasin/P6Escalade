package fr.OCP6Escalade.Entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Topo  implements Serializable{
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String author;
	private String place;
	private String description;
	private Date onlineDate;
	private boolean isAvailable;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User owner;
	@OneToMany(mappedBy="topo",fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;
	
	
	
	public Topo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topo(Date onlineDate, String title, String author, String place, String description) {
		super();
		this.title = title;
		this.author = author;
		this.place = place;
		this.description = description;
		this.isAvailable = true;
		this.onlineDate = onlineDate;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOnlineDate() {
		return onlineDate;
	}

	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
}
