package fr.OCP6Escalade.Entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Site  implements Serializable {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private String place;
	private String country;
	private String title;
	private String cotation;
	private boolean tag;
	private double length=-1;
	private int nbViews=0;
	private int nbPaths=-1;
	private int nbSectors=-1;
	@OneToMany(mappedBy ="site",fetch=FetchType.LAZY)
	private Collection<Comment> comments;
	
	
	
	public Site() {
		super();
		this.length = 0;
		this.nbPaths = 0;
		this.nbSectors = 0;
		this.nbViews=0;
		
	}

	public Site(String description, String place, String country, String title, String cotation, double length,
			int nbPaths, int nbSectors) {
		super();
		this.description = description;
		this.place = place;
		this.country = country;
		this.title = title;
		this.cotation = cotation;
		this.length = length;
		this.nbPaths = nbPaths;
		this.nbSectors = nbSectors;
		this.nbViews=0;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public int getNbViews() {
		return nbViews;
	}

	public void setNbViews(int nbViews) {
		this.nbViews = nbViews;
	}

	public int getNbPaths() {
		return nbPaths;
	}

	public void setNbPaths(int nbPaths) {
		this.nbPaths = nbPaths;
	}

	public int getNbSectors() {
		return nbSectors;
	}

	public void setNbSectors(int nbSectors) {
		this.nbSectors = nbSectors;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}	

}
