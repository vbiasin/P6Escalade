package fr.OCP6Escalade.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.OCP6Escalde.Entites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
	public Optional<Utilisateur> findByMail(String mail);

}
