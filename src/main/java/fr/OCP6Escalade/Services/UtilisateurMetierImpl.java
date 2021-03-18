package fr.OCP6Escalade.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.OCP6Escalade.DAO.UtilisateurRepository;
import fr.OCP6Escalde.Entites.Utilisateur;

public class UtilisateurMetierImpl implements IUtilisateurMetier{

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Override
	public Utilisateur inscription(Utilisateur visiteur) throws Exception {
		Optional<Utilisateur> nouvelUtilisateur = utilisateurRepository.findByMail(visiteur.getMail());
		if(!nouvelUtilisateur.isEmpty()) throw new Exception("Un utilisateur avec cette adresse mail existe déjà !");
		return utilisateurRepository.save(visiteur);
	}

}
