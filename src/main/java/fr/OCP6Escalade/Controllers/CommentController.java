package fr.OCP6Escalade.Controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.OCP6Escalade.Entites.Comment;
import fr.OCP6Escalade.Entites.Site;
import fr.OCP6Escalade.Services.ICommentService;
import fr.OCP6Escalade.Services.ISiteService;
import fr.OCP6Escalade.Services.IUserService;

@Controller
public class CommentController {

	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private ISiteService siteService;

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/target")
	public String target(@RequestParam int idSite, Model model,@RequestParam(name="pageList",defaultValue="0") int pageList,
			@RequestParam(name="size",defaultValue="3") int size) {
		Page<Comment> pageListComments;
		
		try {
			Site s = siteService.consult(idSite);
			model.addAttribute("title",s.getTitle());
			model.addAttribute("country",s.getCountry());
			model.addAttribute("place",s.getPlace());
			model.addAttribute("nbViews",s.getNbViews());
			model.addAttribute("cotation",s.getCotation());
			model.addAttribute("description",s.getDescription());
			model.addAttribute("nbSectors",s.getNbSectors());
			model.addAttribute("nbPaths",s.getNbPaths());
			model.addAttribute("length",s.getLength());
			model.addAttribute("id",idSite);
	
			
			
			pageListComments = commentService.listComment(idSite,pageList,size);
			model.addAttribute("listComments",pageListComments.getContent()); 
			int []pagesListComments = new int[pageListComments.getTotalPages()];
			model.addAttribute("pagesListComments",pagesListComments);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "target";
	}
	
	@PostMapping("/removeComment")
	public String removeTopo(Model model,@RequestParam long idSite, @RequestParam long idComment) {
		model.addAttribute("idSite",idSite);
		try {
			commentService.removeComment(idComment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/target?idSite="+idSite;
	}
	
	@PostMapping("/commentNew")
	public String commentNew(Model model,String comment,@RequestParam long idSite) {
		model.addAttribute("idSite",idSite);
		try {
			User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			commentService.addComment(userService.getUser(activeUser.getUsername()).getId(),idSite,new Comment(new Date(),comment));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/target?idSite="+idSite;
	}
	
}
