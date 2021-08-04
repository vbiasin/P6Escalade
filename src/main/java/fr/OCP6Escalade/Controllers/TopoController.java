package fr.OCP6Escalade.Controllers;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fr.OCP6Escalade.Entites.Topo;
import fr.OCP6Escalade.Services.ITopoService;
import fr.OCP6Escalade.Services.IUserService;


@Controller
public class TopoController {

	@Autowired
	private ITopoService topoService;

	@Autowired
	private IUserService userService;


	@RequestMapping("/topos")
	public String topos(Model model,@RequestParam(name="pageList",defaultValue="0") int pageList,
			@RequestParam(name="size",defaultValue="3") int size,@RequestParam(name="pageMy",defaultValue="0") int pageMy) {

		Page<Topo> pageListTopos;
		Page<Topo> pageMyTopos;
		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {


			pageListTopos = topoService.listTopos(pageList,size);
			model.addAttribute("listTopos",pageListTopos.getContent()); int []
					pagesListTopos = new int[pageListTopos.getTotalPages()];
			model.addAttribute("pagesListTopos",pagesListTopos);


			pageMyTopos = topoService.myTopos(userService.getUser(activeUser.getUsername()).getId(),pageMy,size);
			model.addAttribute("myTopos",pageMyTopos.getContent());
			int [] pagesMyTopos = new int[pageMyTopos.getTotalPages()];
			model.addAttribute("pagesMyTopos",pagesMyTopos);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "topos";
	}

	@PostMapping("/topoNew")
	public String saveTopo(Model model,String title, String author, String place, String description) throws Exception {
		model.addAttribute("title",title);
		model.addAttribute("author",author);
		model.addAttribute("place",place);
		model.addAttribute("description",description);


		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			topoService.saveTopo(userService.getUser(activeUser.getUsername()).getId(),new Topo(new Date(),title,author,place,description));
		} catch (Exception e) {
			model.addAttribute("exception",e.getMessage());	
		}	

		return  "redirect:/topos";
	}

	@PostMapping("/availableTopo")
	public String availableTopo(@RequestParam Long idTopo) {
		try {
			topoService.getAvailable(idTopo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/topos";
	}

	@PostMapping("/removeTopo")
	public String removeTopo(@RequestParam Long idTopo) {
		try {
			topoService.removeTopo(idTopo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/topos";
	}

}
