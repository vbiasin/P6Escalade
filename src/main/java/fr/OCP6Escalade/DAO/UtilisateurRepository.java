package fr.OCP6Escalade.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.OCP6Escalade.Entites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	public Optional<Utilisateur> findByMail(String mail);
	public Optional<Utilisateur> findByMailAndMotDePasse(String mail, String motDePasse);

}
