package fr.OCP6Escalade.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.OCP6Escalade.Entites.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	/*@Query("select * from reservation where'")
	public List<Reservation> listReservation();*/
	
}
