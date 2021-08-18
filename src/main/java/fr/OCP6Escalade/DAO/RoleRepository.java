package fr.OCP6Escalade.DAO;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.OCP6Escalade.Entites.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	
	public Optional<Role> findById(long id);
	public Optional<Role> findByName(String name);

	

}
