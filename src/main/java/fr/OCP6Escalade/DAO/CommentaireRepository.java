package fr.OCP6Escalade.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.OCP6Escalade.Entites.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

	/*@Query("select * from commentaire where id_site=:x")
	public List<Commentaire> listCommentaire(@Param("x")long idSite);*/
	
}
