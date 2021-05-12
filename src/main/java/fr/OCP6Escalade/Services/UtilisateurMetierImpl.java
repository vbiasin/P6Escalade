package fr.OCP6Escalade.Services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.OCP6Escalade.DAO.UtilisateurRepository;
import fr.OCP6Escalade.Entites.Utilisateur;

@Service
@Transactional
public class UtilisateurMetierImpl implements IUtilisateurMetier{

	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Override
	public Utilisateur inscription(Utilisateur visiteur) throws Exception {
		Optional<Utilisateur> nouvelUtilisateur = utilisateurRepository.findByMail(visiteur.getMail());
		if(!nouvelUtilisateur.isEmpty()) throw new Exception("Un utilisateur avec cette adresse mail existe déjà !");
		visiteur.setMotDePasse(bCryptPasswordEncoder.encode(visiteur.getMotDePasse()));
		return utilisateurRepository.save(visiteur);
	}

	@Override
	public boolean estValide(Utilisateur visiteur) throws Exception {
		Optional<Utilisateur> nouvelUtilisateur = utilisateurRepository.findByMailAndMotDePasse(visiteur.getMail(), visiteur.getMotDePasse());
		if(nouvelUtilisateur.isEmpty()) {
			throw new Exception("Login ou mot de passe incorrect!");
		}
		return true;
	}
	
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

	@Override
	public Utilisateur getUtilisateur(String mail) throws Exception {
		Optional<Utilisateur>utilisateurCo = utilisateurRepository.findByMail(mail);
		if(utilisateurCo.isEmpty()) throw new Exception("Cette adresse mail n'a pas été trouvée !");
		return utilisateurCo.get();
	}

}
