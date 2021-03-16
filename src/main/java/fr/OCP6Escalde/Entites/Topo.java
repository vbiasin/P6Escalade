package fr.OCP6Escalde.Entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Topo  implements Serializable{
	
	@Id@GeneratedValue
	private long id;
	private String nom;
	private String auteur;
	private String lieu;
	private String description;
	private Date dateParrution;
	private Date dateMiseEnLigne;
	private boolean estDispo;
	@ManyToOne(fetch=FetchType.LAZY)
	private Utilisateur proprietaire;
	@OneToMany(mappedBy="topo", fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;
	
	
	
	public Topo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topo(String nom, String auteur, String lieu, String description, Date dateParrution, Date dateMiseEnLigne) {
		super();
		this.nom = nom;
		this.auteur = auteur;
		this.lieu = lieu;
		this.description = description;
		this.dateParrution = dateParrution;
		this.dateMiseEnLigne = dateMiseEnLigne;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateParrution() {
		return dateParrution;
	}

	public void setDateParrution(Date dateParrution) {
		this.dateParrution = dateParrution;
	}

	public Date getDateMiseEnLigne() {
		return dateMiseEnLigne;
	}

	public void setDateMiseEnLigne(Date dateMiseEnLigne) {
		this.dateMiseEnLigne = dateMiseEnLigne;
	}

	public boolean isEstDispo() {
		return estDispo;
	}

	public void setEstDispo(boolean estDispo) {
		this.estDispo = estDispo;
	}

	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
}
