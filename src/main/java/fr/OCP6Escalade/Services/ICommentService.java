package fr.OCP6Escalade.Services;



import org.springframework.data.domain.Page;

import fr.OCP6Escalade.Entites.Comment;

public interface ICommentService {

	public Comment addComment(long idSite, long idUser, Comment comment) throws Exception;
	public Comment modifyComment(long idComment, String changes) throws Exception;
	public void removeComment(long idComment) throws Exception;
	public Page<Comment> listComment(long idSite, int pages, int size) throws Exception;
	
}
