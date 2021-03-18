package fr.OCP6Escalade.Services;

import java.util.List;

import fr.OCP6Escalde.Entites.Topo;

public interface ITopoMetier {

	public Topo enregistrerTopo(long idUtilisateur, Topo topo) throws Exception;
	public Topo rendreDisponible(long idTopo)throws Exception;
	public void supprimerTopo(long idTopo)throws Exception;
	public List<Topo> listTopo()throws Exception;
	
}
