package fr.OCP6Escalade.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fr.OCP6Escalade.Entites.Site;
import fr.OCP6Escalade.Services.ISiteService;
import fr.OCP6Escalade.Services.IUserService;

@Controller
public class SiteController {
	
	@Autowired
	private ISiteService siteService;

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/sites")
	public String sites() {
		
		return "sites";
	}
	
	@PostMapping("/siteNew")
	public String saveSite(Model model,String description, String place, String country, String title, String cotation, double length,
			int nbPaths, int nbSectors) throws Exception {
		model.addAttribute("title",title);
		model.addAttribute("country",country);
		model.addAttribute("place",place);
		model.addAttribute("description",description);
		model.addAttribute("cotation",cotation);
		model.addAttribute("length",length);
		model.addAttribute("nbPaths",nbPaths);
		model.addAttribute("nbSectors",nbSectors);
		

		if(title=="" || country=="" || description=="" || cotation=="" || length==-1 || nbPaths==-1 || nbSectors==-1 ) {
			System.out.println("Tous les champs doivent être remplis !");
			return  "redirect:/sites";
		}

		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			siteService.createSite(userService.getUser(activeUser.getUsername()).getId(),new Site(description, place, country, title, cotation,(Double)length,(Integer)nbPaths, (Integer)nbSectors));
		} catch (Exception e) {
			model.addAttribute("exception",e.getMessage());	
		}	

		return  "redirect:/sites";
	}
	
	
	@PostMapping("/searchSite")
	public String searchSite(Model model, String country, String place, String cotationMin, String cotationMax, Integer nbSectorsMin,Integer nbSectorsMax, 
			Integer nbPathsMin, Integer nbPathsMax , @RequestParam(name="pageList",defaultValue="0") int pageList,@RequestParam(name="size",defaultValue="30") int size) throws Exception {
		if(cotationMin.isEmpty())cotationMin="1";
		if(cotationMax.isEmpty())cotationMax="9c";
		if(nbSectorsMin==null)nbSectorsMin=0;
		if(nbPathsMin==null)nbPathsMin=0;
		if(nbSectorsMax==null)nbSectorsMax=2000000000;
		if(nbPathsMax==null)nbPathsMax=2000000000;
		
		model.addAttribute("country",country);
		model.addAttribute("place",place);
		model.addAttribute("cotationMin",cotationMin);
		model.addAttribute("cotationMax",cotationMax);
		model.addAttribute("nbPathsMin",nbPathsMin);
		model.addAttribute("nbPathsMax",nbPathsMax);
		model.addAttribute("nbSectorsMin",nbSectorsMin);
		model.addAttribute("nbSectorsMax",nbSectorsMax);
		 
		Page<Site> pageListSites;

		try {
			
				pageListSites = siteService.searchSite(country, place, (Integer) nbSectorsMin,(Integer) nbSectorsMax, ( Integer)nbPathsMin,(Integer)nbPathsMax,cotationMin,cotationMax,pageList,size);
				model.addAttribute("listSites",pageListSites.getContent()); 
				int []pagesListSites = new int[pageListSites.getTotalPages()];
				model.addAttribute("pagesListSites",pagesListSites);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sites";
	}

}
