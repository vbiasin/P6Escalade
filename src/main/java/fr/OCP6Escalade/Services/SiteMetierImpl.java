package fr.OCP6Escalade.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.OCP6Escalade.DAO.SiteRepository;
import fr.OCP6Escalade.DAO.UtilisateurRepository;
import fr.OCP6Escalde.Entites.Site;
import fr.OCP6Escalde.Entites.Utilisateur;

public class SiteMetierImpl implements ISiteMetier {
	
	@Autowired
	SiteRepository siteRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public Site consulter(long idSite) throws Exception {
		Optional<Site> site = siteRepository.findById(idSite);
		if(site.isEmpty()) throw new Exception("Le site n'existe pas !");
		return site.get();
	}

	@Override
	public Site creerSite(long idAuteur, Site site) throws Exception {
		Optional<Utilisateur> auteur = utilisateurRepository.findById(idAuteur);
		if(auteur.isEmpty()) throw new Exception("Utilisateur Inconnu !");
		return siteRepository.save(site);
	}

	@Override
	public Site taguerSite(long idSite) throws Exception {
		Optional<Site> site = siteRepository.findById(idSite);
		if(site.isEmpty()) throw new Exception("Le site n'existe pas !");
		site.get().setTag(true);
		return siteRepository.save(site.get());
	}

	@Override
	public void supprimerSite(long idSite) throws Exception {
		Optional<Site> site = siteRepository.findById(idSite);
		if(site.isEmpty()) throw new Exception("Le site n'existe pas !");
		siteRepository.delete(site.get());
	}

}
