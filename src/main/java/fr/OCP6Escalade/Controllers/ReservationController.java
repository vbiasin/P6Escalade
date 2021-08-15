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

import fr.OCP6Escalade.Entites.Reservation;
import fr.OCP6Escalade.Services.IReservationService;
import fr.OCP6Escalade.Services.IUserService;

@Controller
public class ReservationController {
	
	@Autowired
	private IReservationService reservationService;
	
	@Autowired
	private IUserService userService;
	

	@RequestMapping("/reservations")
	public String reservations(Model model,@RequestParam(name="pageList",defaultValue="0") int pageList,
			@RequestParam(name="size",defaultValue="3") int size,@RequestParam(name="pageMy",defaultValue="0") int pageMy) {

		Page<Reservation> pageListReservations;
		Page<Reservation> pageMyReservations;
		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			
			if(userService.getUser(activeUser.getUsername()).getContact()==null) {
				return "contact";
			}
			
			pageListReservations = reservationService.listReservations(userService.getUser(activeUser.getUsername()).getId(),pageList,size);
			model.addAttribute("listReservations",pageListReservations.getContent()); 
			int []pagesListReservations = new int[pageListReservations.getTotalPages()];
			model.addAttribute("pagesListReservations",pagesListReservations);

			pageMyReservations = reservationService.myReservations(userService.getUser(activeUser.getUsername()).getId(),pageMy,size);
			model.addAttribute("myReservations",pageMyReservations.getContent());
			int [] pagesMyReservations = new int[pageMyReservations.getTotalPages()];
			model.addAttribute("pagesMyReservations",pagesMyReservations);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "reservations";
	}
	
	@PostMapping("/reservations")
	public String doReservation(@RequestParam Long idTopo) {
		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			reservationService.doReservation(userService.getUser(activeUser.getUsername()).getId(), idTopo,new Reservation());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reservations";
	}
	
	
	@PostMapping("/acceptReservation")
	public String acceptReservation(@RequestParam Long idReservation) {
		try {
			reservationService.acceptReservation(idReservation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reservations";
	}
	
	@PostMapping("/refuseReservation")
	public String refuseReservation(@RequestParam Long idReservation,@RequestParam Long idTopo) {
		System.out.println("ID Réservation " + idReservation + " ID Topo " +idTopo);
		try {
			reservationService.refuseReservation(idReservation,idTopo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reservations";
	}
	
}
