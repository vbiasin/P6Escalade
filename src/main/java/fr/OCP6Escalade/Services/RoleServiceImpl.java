package fr.OCP6Escalade.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.OCP6Escalade.DAO.RoleRepository;
import fr.OCP6Escalade.DAO.UserRepository;
import fr.OCP6Escalade.Entites.Role;
import fr.OCP6Escalade.Entites.User;

public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void addRoleToUser(String mail, long idRole) throws Exception {
		Optional<User>user = userRepository.findByMail(mail);
		if(user.isEmpty()) throw new Exception("Cet utilisateur n'a pas été trouvé !");
		
		
	}

	@Override
	public void removeRoleFromUser(String mail, long idRole) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
