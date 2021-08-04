package fr.OCP6Escalade.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.OCP6Escalade.Entites.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	

}
