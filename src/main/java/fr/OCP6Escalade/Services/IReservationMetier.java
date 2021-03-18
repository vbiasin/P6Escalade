package fr.OCP6Escalade.Services;

import java.util.List;

import fr.OCP6Escalde.Entites.Reservation;

public interface IReservationMetier {
	
	public Reservation faireReservation(long idDemandeur, long idTopo, Reservation reservation) throws Exception;
	public Reservation accepterReserrvation(long idReservation) throws Exception;
	public Reservation refuserReservation(long idReservation) throws Exception;
	public List<Reservation> listReservation()throws Exception;

}
