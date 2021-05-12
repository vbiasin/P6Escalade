package fr.OCP6Escalade.Entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Commentaire  implements Serializable {

	@Id@GeneratedValue
	private long id;
	private Date datePublication;
	private String text;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_utilisateur")
	private Utilisateur auteur;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_site")
	private Site site;
	
	
	
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commentaire(Date datePublication, String text) {
		super();
		this.datePublication = datePublication;
		this.text = text;
	}

	
		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}
