package fr.OCP6Escalade.DAO;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.OCP6Escalade.Entites.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	@Query("select r1 from Reservation r1 where r1.topo.owner.id=:x")
	public Page<Reservation> listReservations(@Param("x")long idOwner, Pageable pageable);
	
	@Query("select r2 from Reservation r2 where r2.applicant.id=:y ")
	public Page<Reservation> myReservations(@Param("y")long idApplicant, Pageable pageable);
	
}
