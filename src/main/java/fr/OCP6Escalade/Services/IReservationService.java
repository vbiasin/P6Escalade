package fr.OCP6Escalade.Services;


import org.springframework.data.domain.Page;

import fr.OCP6Escalade.Entites.Reservation;

public interface IReservationService {
	
	public Reservation doReservation(long idApplicant, long idTopo, Reservation reservation) throws Exception;
	public Reservation acceptReservation(long idReservation) throws Exception;
	public Reservation refuseReservation(long idReservation, long idTopo) throws Exception;
	public Page<Reservation> listReservations(long idOwner,int pages, int size)throws Exception;
	public Page<Reservation> myReservations(long idApplicant,int pages, int size)throws Exception;

}
