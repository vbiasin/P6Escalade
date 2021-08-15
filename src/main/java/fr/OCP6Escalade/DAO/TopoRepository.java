package fr.OCP6Escalade.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.OCP6Escalade.Entites.Topo;

public interface TopoRepository extends JpaRepository<Topo, Long>{

	
	  @Query("select t1 from Topo t1 where t1.isAvailable='1'") 
	  public Page<Topo> listTopos(Pageable pageable);
	  
	  @Query("select t2 from Topo t2 where t2.owner.id=:x ") 
	  public Page<Topo> myTopos(@Param("x")long idOwner, Pageable pageable);
		 

}
