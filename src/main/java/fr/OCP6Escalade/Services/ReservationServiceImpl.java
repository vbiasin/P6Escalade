package fr.OCP6Escalade.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.OCP6Escalade.DAO.ReservationRepository;
import fr.OCP6Escalade.DAO.TopoRepository;
import fr.OCP6Escalade.DAO.UserRepository;
import fr.OCP6Escalade.Entites.Reservation;
import fr.OCP6Escalade.Entites.Topo;
import fr.OCP6Escalade.Entites.User;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TopoRepository topoRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation doReservation(long idApplicant, long idTopo, Reservation reservation) throws Exception {
		Optional<User> applicant = userRepository.findById(idApplicant);
		Optional<Topo> topo = topoRepository.findById(idTopo);
		if(applicant.isEmpty())throw new Exception("L'utilisateur n'existe pas !");
		if(topo.isEmpty())throw new Exception("Le topo n'existe pas !");
		topo.get().setAvailable(false);
		reservation.setApplicant(applicant.get());
		reservation.setTopo(topo.get());
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation acceptReservation(long idReservation) throws Exception {
		Optional<Reservation> reservation = reservationRepository.findById(idReservation);
		if(reservation.isEmpty())throw new Exception("La réservation n'existe pas !");
		reservation.get().setStatus("acceptée");
		return reservationRepository.saveAndFlush(reservation.get());
	}

	@Override
	public Reservation refuseReservation(long idReservation,long idTopo) throws Exception {
		Optional<Reservation> reservation = reservationRepository.findById(idReservation);
		Optional<Topo> topo = topoRepository.findById(idTopo);
		if(reservation.isEmpty())throw new Exception("La réservation n'existe pas !");
		if(topo.isEmpty())throw new Exception("Le topo n'existe pas !");
		topo.get().setAvailable(true);
		topoRepository.saveAndFlush(topo.get());
		reservation.get().setStatus("refusée");
		return reservationRepository.saveAndFlush(reservation.get());
	}

	@Override
	public Page<Reservation> listReservations(long idOwner,int pages, int size) throws Exception {
		return reservationRepository.listReservations(idOwner, PageRequest.of(pages, size));
	}

	@Override
	public Page<Reservation> myReservations(long idApplicant,int pages, int size) throws Exception {
		return reservationRepository.myReservations(idApplicant, PageRequest.of(pages, size));
	}

}
