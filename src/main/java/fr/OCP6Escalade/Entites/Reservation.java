package fr.OCP6Escalade.Entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation  implements Serializable {

	@Id@GeneratedValue
	private long id;
	private String status;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_topo")
	private Topo topo;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_utilisateur")
	private Utilisateur demandeur;
	
	
	
	public Reservation() {
		super();
		this.status = "en cours";
	}

	public Reservation(String status) {
		super();
		this.status = status;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	public Utilisateur getDemandeur() {
		return demandeur;
	}

	public void setDemandeur(Utilisateur demandeur) {
		this.demandeur = demandeur;
	}
		
}
