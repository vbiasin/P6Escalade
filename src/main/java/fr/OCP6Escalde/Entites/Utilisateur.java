package fr.OCP6Escalde.Entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Utilisateur implements Serializable {

	@Id@GeneratedValue
	private long id;
	private String mail;
	private String motDePasse;
	private String role;
	@OneToMany(mappedBy="proprietaire", fetch=FetchType.LAZY)
	private Collection<Topo> topos;
	@OneToMany(mappedBy="auteur", fetch=FetchType.LAZY)
	private Collection<Commentaire> commentaires;
	@OneToMany(mappedBy="demandeur", fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;
	@OneToOne
	private Contact contact;
	
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String mail, String motDePasse) {
		super();
		this.mail = mail;
		this.motDePasse = motDePasse;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Topo> getTopos() {
		return topos;
	}

	public void setTopos(Collection<Topo> topos) {
		this.topos = topos;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
		
	
}
