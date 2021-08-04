package fr.OCP6Escalade.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.OCP6Escalade.Entites.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByMail(String mail);
	public Optional<User> findByMailAndPassword(String mail, String password);

}
