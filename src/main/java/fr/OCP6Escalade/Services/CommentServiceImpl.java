package fr.OCP6Escalade.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.OCP6Escalade.DAO.CommentRepository;
import fr.OCP6Escalade.DAO.SiteRepository;
import fr.OCP6Escalade.DAO.UserRepository;
import fr.OCP6Escalade.Entites.Comment;
import fr.OCP6Escalade.Entites.Site;
import fr.OCP6Escalade.Entites.User;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SiteRepository siteRepository;
	
	@Override
	public Comment addComment(long idUser, long idSite, Comment comment) throws Exception {
		Optional<Site> site = siteRepository.findById(idSite);
		Optional<User> author = userRepository.findById(idUser);
		if(site.isEmpty())throw new Exception("Le site n'existe pas !");
		if(author.isEmpty())throw new Exception("L'utilisateur n'existe pas !");
		comment.setAuthor(author.get());
		comment.setSite(site.get());
		return commentRepository.save(comment);
	}

	@Override
	public Comment modifyComment(long idComment, String changes) throws Exception {
		Optional<Comment> comment = commentRepository.findById(idComment);
		if(comment.isEmpty()) throw new Exception("Le commentaire n'existe pas !");
		comment.get().setText(changes);
		return commentRepository.saveAndFlush(comment.get());
	}

	@Override
	public void removeComment(long idComment) throws Exception {
		Optional<Comment> comment = commentRepository.findById(idComment);
		if(comment.isEmpty()) throw new Exception("Le commentaire n'existe pas !");
		commentRepository.delete(comment.get());
	}

	@Override
	public Page<Comment> listComment(long idSite, int pages, int size) throws Exception {
		return commentRepository.listComment(idSite,PageRequest.of(pages, size));
	}

}
