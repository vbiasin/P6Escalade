package fr.OCP6Escalade.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.OCP6Escalade.DAO.CommentaireRepository;
import fr.OCP6Escalade.DAO.SiteRepository;
import fr.OCP6Escalade.DAO.UtilisateurRepository;
import fr.OCP6Escalde.Entites.Commentaire;
import fr.OCP6Escalde.Entites.Site;
import fr.OCP6Escalde.Entites.Utilisateur;

public class CommentaireMetierImpl implements ICommentaireMetier {

	@Autowired
	CommentaireRepository commentaireRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	SiteRepository siteRepository;
	
	@Override
	public Commentaire ajouterCommentaire(long idSite, long idUtilisateur, Commentaire commentaire) throws Exception {
		Optional<Site> site = siteRepository.findById(idSite);
		Optional<Utilisateur> auteur = utilisateurRepository.findById(idUtilisateur);
		if(site.isEmpty())throw new Exception("Le site n'existe pas !");
		if(auteur.isEmpty())throw new Exception("Utilisateur inexistant !");
		commentaire.setAuteur(auteur.get());
		commentaire.setSite(site.get());
		return commentaireRepository.save(commentaire);
	}

	@Override
	public Commentaire modifierCommentaire(long idCommentaire, Commentaire nouveauCommentaire) throws Exception {
		Optional<Commentaire> commentaire = commentaireRepository.findById(idCommentaire);
		if(commentaire.isEmpty()) throw new Exception("Le commentaire n'existe pas !");
		commentaire.get().setText(nouveauCommentaire.getText());
		return commentaireRepository.saveAndFlush(commentaire.get());
	}

	@Override
	public void supprimerCommentaire(long idCommentaire) throws Exception {
		Optional<Commentaire> commentaire = commentaireRepository.findById(idCommentaire);
		if(commentaire.isEmpty()) throw new Exception("Le commentaire n'existe pas !");
		commentaireRepository.delete(commentaire.get());
	}

	@Override
	public List<Commentaire> listCommentaire(long idSite) throws Exception {
		return null;//commentaireRepository.listCommentaire(idSite);
	}

}
