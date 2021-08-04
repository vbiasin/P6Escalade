package fr.OCP6Escalade.Entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Role implements Serializable {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@ManyToMany(mappedBy = "role")
	private Collection<User> user;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Role(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getId() {
		return id;
	}
	
	

}
