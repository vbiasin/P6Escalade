package fr.OCP6Escalade.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OCP6EscladeController {
	
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/administration")
	public String administration() {
		return "administration";
	}

}
