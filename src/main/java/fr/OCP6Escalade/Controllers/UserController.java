package fr.OCP6Escalade.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.OCP6Escalade.Entites.User;
import fr.OCP6Escalade.Services.IUserService;



@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	public boolean passwordComplexity(String password) throws Exception {
	    int counter = 0;
		boolean control = true;
		boolean uppercase = false;
		boolean lowercase = false;
		boolean special = false;
		boolean number = false;
		String specials = "@+-=*/.&µ%$}])|[({,!:?\";";
		String numbers = "0123456789";
		String lowercases="azertyuiopqsdfghjklmwxcvbn";
		//On vérifie la longueur du mot de passe en premier
		if(password.length()<8) {
			control =false;
			throw new Exception("Le mot de passe doit faire au moins 8 caractères");
		}
		else {
			while(counter<password.length() && (uppercase==false || lowercase==false || number==false || special==false)) {
				//on génère une chaine de caractère contenant le caractère à la position compteur
				String sequence = password.substring(counter, counter+1);
				//On vérifie les 4 critères 
				if(number==false) {
					if(numbers.contains(sequence)) number=true;
				}
				if(lowercase==false) {
					if(lowercases.contains(sequence)) lowercase=true;
				}
				if(uppercase==false) {
					String majuscules = lowercases.toUpperCase();
					if(majuscules.contains(sequence)) uppercase=true;
				}
				if(special==false) {
					if(specials.contains(sequence)) special=true;
				}
				
				counter++;
			}
			
			if(uppercase==false || lowercase==false || number==false || special==false) {
				control=false;
				if(uppercase==false) throw new Exception("Le mot de passe doit contenir au moins une majuscule");
				if(lowercase==false) throw new Exception("Le mot de passe doit contenir au moins une minuscule");
				if(special==false) throw new Exception("Le mot de passe doit contenir au moins un caractère spécial");
				if(number==false) throw new Exception("Le mot de passe doit contenir au moins un chiffre");
			}
		}
		return control;
	}
	
	
	@RequestMapping("/inscription")
	public String index() {
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String inscription(Model model,String mail, String password) {
		model.addAttribute("mail",mail);
		model.addAttribute("password",password);
		boolean test=false;
		try {
			 test = passwordComplexity(password);
		} catch (Exception e) {
			model.addAttribute("exception",e.getMessage());
			return  "inscription";
		}
		if(test==true) {
			try {
				userService.register(new User(mail,password));
				return "inscriptionResult";
			} catch (Exception e) {
				model.addAttribute("exception",e.getMessage());	
			}		
		}
		
		return  "inscription";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@PostMapping("/login")
	public String seConnecter(Model model,String mail, String motDePasse) {
		model.addAttribute("username",mail);
		model.addAttribute("password",motDePasse);
		try {
			userService.isValid(new User(mail,motDePasse));
			return "home";
			} catch (Exception e) {
				model.addAttribute("exception",e.getMessage());	
			}	
		return  "login";
	}
}
