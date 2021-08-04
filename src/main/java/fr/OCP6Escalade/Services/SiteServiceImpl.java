package fr.OCP6Escalade.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.OCP6Escalade.DAO.SiteRepository;
import fr.OCP6Escalade.DAO.UserRepository;
import fr.OCP6Escalade.Entites.Site;
import fr.OCP6Escalade.Entites.User;

@Service
@Transactional
public class SiteServiceImpl implements ISiteService {

	@Autowired
	SiteRepository siteRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Site consult(long idSite) throws Exception {
		Optional<Site> site = siteRepository.findById(idSite);
		if (site.isEmpty())
			throw new Exception("Le site n'existe pas !");
		return site.get();
	}

	@Override
	public Site createSite(long idAuthor, Site newSite) throws Exception {
		Optional<User> author = userRepository.findById(idAuthor);
		if (author.isEmpty())
			throw new Exception("User Inconnu !");
		Optional<Site> site = siteRepository.findByTitle(newSite.getTitle());
		if (!site.isEmpty())
			throw new Exception("Un site ayant le même titre existe déjà !");
		return siteRepository.save(newSite);
	}

	@Override
	public Site tagSite(long idSite) throws Exception {
		Optional<Site> site = siteRepository.findById(idSite);
		if (site.isEmpty())
			throw new Exception("Le site n'existe pas !");
		site.get().setTag(true);
		return siteRepository.save(site.get());
	}

	@Override
	public void removeSite(long idSite) throws Exception {
		Optional<Site> site = siteRepository.findById(idSite);
		if (site.isEmpty())
			throw new Exception("Le site n'existe pas !");
		siteRepository.delete(site.get());
	}

	@Override
	public Page<Site> searchSite(String country, String place, int nbSectorsMin,int nbSectorsMax, int nbPathsMin, int nbPathsMax,String cotationMin, String cotationMax,int pages, int size) throws Exception {
		return siteRepository.searchSite(country, place,nbSectorsMin, nbSectorsMax,nbPathsMin,nbPathsMax, cotationMin,cotationMax, PageRequest.of(pages,size));
	}

}
