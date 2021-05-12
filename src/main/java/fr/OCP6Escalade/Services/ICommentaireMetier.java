package fr.OCP6Escalade.Services;

import java.util.List;

import fr.OCP6Escalade.Entites.Commentaire;

public interface ICommentaireMetier {

	public Commentaire ajouterCommentaire(long idSite, long idUtilisateur, Commentaire commentaire) throws Exception;
	public Commentaire modifierCommentaire(long idCommentaire, Commentaire nouveauCommentaire) throws Exception;
	public void supprimerCommentaire(long idCommentaire) throws Exception;
	public List<Commentaire> listCommentaire(long idSite) throws Exception;
	
}
