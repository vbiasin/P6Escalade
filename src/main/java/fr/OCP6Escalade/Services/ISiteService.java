package fr.OCP6Escalade.Services;

import org.springframework.data.domain.Page;

import fr.OCP6Escalade.Entites.Site;

public interface ISiteService {

	public Site consult(long idSite)throws Exception;
	public Site createSite(long idAuthor, Site site)throws Exception;
	public Site tagSite(long idSite) throws Exception;
	public void removeSite(long idSite)throws Exception;

	public Page<Site> searchSite(String country,String place,int nbSectorsMin,int nbSectorsMax, int nbPathsMin,int nbPathsMax,String cotationMin, String cotationMax,int pages, int size) throws Exception;
		
}
