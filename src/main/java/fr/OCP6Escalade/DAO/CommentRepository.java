package fr.OCP6Escalade.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.OCP6Escalade.Entites.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query("select c from Comment c where c.site.id=:x")
	public Page<Comment> listComment(@Param("x")long idSite, Pageable pageable);
	
}
