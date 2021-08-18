package fr.OCP6Escalade.Entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
public class User implements Serializable {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String mail;
	private String password;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	  name = "users_roles", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;
	@OneToMany(mappedBy="owner",fetch=FetchType.LAZY)
	private Collection<Topo> topos;
	@OneToMany(mappedBy="author",fetch=FetchType.LAZY)
	private Collection<Comment> comments;
	@OneToMany(mappedBy="applicant",fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;
	@OneToOne
	private Contact contact;
	
	
	
	public User() {
		super();
	}

	public User(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Topo> getTopos() {
		return topos;
	}

	public void setTopos(Collection<Topo> topos) {
		this.topos = topos;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setCommentaires(Collection<Comment> comments) {
		this.comments = comments;
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

	public  Collection<Role> getRole() {
		return roles;
	}

	public void setRole( Collection<Role> roles) {
		this.roles = roles;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}


	
}
