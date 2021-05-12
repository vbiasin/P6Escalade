package fr.OCP6Escalade.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.OCP6Escalade.Entites.Site;

public interface SiteRepository extends JpaRepository<Site,Long>{

	public Optional<Site> findByTitre(String titre);
}
