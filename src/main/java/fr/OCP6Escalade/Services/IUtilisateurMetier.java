package fr.OCP6Escalade.Services;

import java.util.Optional;

import fr.OCP6Escalade.Entites.Utilisateur;

public interface IUtilisateurMetier {
	
	public Utilisateur inscription(Utilisateur visiteur) throws Exception;
	public boolean estValide(Utilisateur visiteur) throws Exception;
	public Utilisateur getUtilisateur(String mail) throws Exception;

}
