package fr.OCP6Escalade.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.OCP6Escalde.Entites.Topo;

public interface TopoRepository extends JpaRepository<Topo, Long>{

	/*@Query("select * from topo where est_dispo='true'")
	public List<Topo> listTopo();*/
	
}
