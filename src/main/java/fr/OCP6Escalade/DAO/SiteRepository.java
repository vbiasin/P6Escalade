package fr.OCP6Escalade.DAO;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import fr.OCP6Escalade.Entites.Site;

public interface SiteRepository extends JpaRepository<Site,Long>{


	public Optional<Site> findByTitle(String title);
	
	@Query("SELECT s from Site s where (:country is null or LOWER(s.country) LIKE %:country%) "
			  + "and (:place is null or LOWER(s.place) LIKE %:place%)"
			  +"and (:nbSectorsMin is null or LOWER(s.nbSectors) >= :nbSectorsMin)" 
			  +"and (:nbSectorsMax is null or LOWER(s.nbSectors) <= :nbSectorsMax)"
			  +"and (:nbPathsMin is null or LOWER(s.nbPaths) >= :nbPathsMin)"
			  +"and (:nbPathsMax is null or LOWER(s.nbPaths) <= :nbPathsMax)"
			  +"and (:cotationMin is null or LOWER(s.cotation)  >= :cotationMin)"
			  +"and (:cotationMax is null or LOWER(s.cotation)  <= :cotationMax)"
	/*
	 * +
	 * "and ((:cotationMin or :cotationMax) is null or LOWER(s.cotation) BETWEEN :cotationMin and :cotationMax)"
	 */)

			public Page<Site> searchSite(@Param("country")String country,@Param("place")String place,@Param("nbSectorsMin") int nbSectorsMin,@Param("nbSectorsMax") int nbSectorsMax,
					@Param("nbPathsMin") int nbPathsMin,@Param("nbPathsMax") int nbPathsMax,@Param("cotationMin") String cotationMin,@Param("cotationMax") String cotationMax, Pageable pageable);


	
			/*
			 * @Query("SELECT s from Site s where (:country is null or LOWER(s.country) LIKE %:country%) "
			 * + "and (:place is null or LOWER(s.place) LIKE %:place%)" +
			 * "and (:nbSectorsMin is null or LOWER(s.nbSectors) >= :nbSectorsMin)" +
			 * "and (:nbSectorsMax is null or LOWER(s.nbSectors) <= :nbSectorsMax)" +
			 * +"and (:nbPathsMin is null or s.nbPaths >= :nbPathsMin)" +
			 * "and (:nbPathsMax is null or s.nbPaths <= :nbPathsMax)")
			 * 
			 * public Page<Site> searchSite(@Param("country")String
			 * country,@Param("place")String place,@Param("nbSectorsMin") int
			 * nbSectorsMin,@Param("nbSectorsMax") int nbSectorsMax,
			 * 
			 * @Param("nbPathsMin") int nbPathsMin,@Param("nbPathsMax") int
			 * nbPathsMax,Pageable pageable);
			 */
	 
	
}
/*
 * " +
 * 
 */

/*
 * 
 * 
 * 
 */
