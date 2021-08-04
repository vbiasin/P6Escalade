package fr.OCP6Escalade.Services;


import org.springframework.data.domain.Page;

import fr.OCP6Escalade.Entites.Topo;

public interface ITopoService {

	public Topo saveTopo(long idOwner, Topo topo) throws Exception;
	public Topo getAvailable(long idTopo)throws Exception;
	public void removeTopo(long idTopo)throws Exception;
	public Page<Topo> listTopos(int pages, int size)throws Exception;
	public Page<Topo> myTopos(long idOwner,int pages, int size)throws Exception;
	
}
