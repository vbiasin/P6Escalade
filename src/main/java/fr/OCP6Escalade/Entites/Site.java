package fr.OCP6Escalade.Entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Site  implements Serializable {
	
	@Id@GeneratedValue
	private long id;
	private String description;
	private String lieu;
	private String pays;
	private String titre;
	private String cotation;
	private boolean tag;
	private double longueur;
	private int nbVues;
	private int nbVoies;
	private int nbSecteurs;
	@OneToMany(mappedBy ="site",fetch=FetchType.LAZY)
	private Collection<Commentaire> commentaires;
	
	
	
	public Site() {
		super();
	}

	public Site(String description, String lieu, String pays, String titre, String cotation, double longueur,
			int nbVoies, int nbSecteurs) {
		super();
		this.description = description;
		this.lieu = lieu;
		this.pays = pays;
		this.titre = titre;
		this.cotation = cotation;
		this.longueur = longueur;
		this.nbVoies = nbVoies;
		this.nbSecteurs = nbSecteurs;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public boolean isTag() {
		return tag;
	}

	public void setTag(boolean tag) {
		this.tag = tag;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public int getNbVues() {
		return nbVues;
	}

	public void setNbVues(int nbVues) {
		this.nbVues = nbVues;
	}

	public int getNbVoies() {
		return nbVoies;
	}

	public void setNbVoies(int nbVoies) {
		this.nbVoies = nbVoies;
	}

	public int getNbSecteurs() {
		return nbSecteurs;
	}

	public void setNbSecteurs(int nbSecteurs) {
		this.nbSecteurs = nbSecteurs;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}	

}
