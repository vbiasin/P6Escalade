package fr.OCP6Escalade.Entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Comment  implements Serializable {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date publicationDate;
	private String text;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUser")
	private User author;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idSite")
	private Site site;
	
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Date publicationDate, String text) {
		super();
		this.publicationDate = publicationDate;
		this.text = text;
	}

	
		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}
