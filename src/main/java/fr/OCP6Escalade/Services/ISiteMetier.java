package fr.OCP6Escalade.Services;

import fr.OCP6Escalade.Entites.Site;

public interface ISiteMetier {

	public Site consulter(long idSite)throws Exception;
	public Site creerSite(long idAuteur, Site site)throws Exception;
	public Site taguerSite(long idSite) throws Exception;
	public void supprimerSite(long idSite)throws Exception;
	
}
