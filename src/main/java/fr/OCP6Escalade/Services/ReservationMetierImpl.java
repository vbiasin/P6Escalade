package fr.OCP6Escalade.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.OCP6Escalade.DAO.ReservationRepository;
import fr.OCP6Escalade.DAO.TopoRepository;
import fr.OCP6Escalade.DAO.UtilisateurRepository;
import fr.OCP6Escalade.Entites.Reservation;
import fr.OCP6Escalade.Entites.Topo;
import fr.OCP6Escalade.Entites.Utilisateur;

@Service
@Transactional
public class ReservationMetierImpl implements IReservationMetier{

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	TopoRepository topoRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation faireReservation(long idDemandeur, long idTopo, Reservation reservation) throws Exception {
		Optional<Utilisateur> demandeur = utilisateurRepository.findById(idDemandeur);
		Optional<Topo> topo = topoRepository.findById(idTopo);
		if(demandeur.isEmpty())throw new Exception("L'utilisateur n'existe pas !");
		if(topo.isEmpty())throw new Exception("Le topo n'existe pas !");
		reservation.setDemandeur(demandeur.get());
		reservation.setTopo(topo.get());
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation accepterReserrvation(long idReservation) throws Exception {
		Optional<Reservation> reservation = reservationRepository.findById(idReservation);
		if(reservation.isEmpty())throw new Exception("La réservation n'existe pas !");
		reservation.get().setStatus("acceptée");
		return reservationRepository.saveAndFlush(reservation.get());
	}

	@Override
	public List<Reservation> listReservation() throws Exception {
		return null;//reservationRepository.listReservation();
	}

	@Override
	public Reservation refuserReservation(long idReservation) throws Exception {
		Optional<Reservation> reservation = reservationRepository.findById(idReservation);
		if(reservation.isEmpty())throw new Exception("La réservation n'existe pas !");
		reservation.get().setStatus("refusée");
		return reservationRepository.saveAndFlush(reservation.get());
	}

}
