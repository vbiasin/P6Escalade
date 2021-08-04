package fr.OCP6Escalade.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.OCP6Escalade.Entites.Contact;
import org.springframework.security.core.userdetails.User;
import fr.OCP6Escalade.Services.IContactService;
import fr.OCP6Escalade.Services.IUserService;

@Controller
public class ContactController {

	@Autowired
	IContactService contactService;
	
	@Autowired
	private IUserService userService;
	
	
	@RequestMapping("/contact")
	public String index() {
		return "contact";
	}
	
	@PostMapping("/addContact")
	public String contact(Model model,String lastName, String firstName, String address) {
		model.addAttribute("lastName",lastName);
		model.addAttribute("firstName",firstName);
		model.addAttribute("address",address);
		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			contactService.addContact(userService.getUser(activeUser.getUsername()).getId(),new Contact(lastName,firstName, address));
		} catch (Exception e) {
			model.addAttribute("exception",e.getMessage());	
		}		
		return  "contact";
		}
}
