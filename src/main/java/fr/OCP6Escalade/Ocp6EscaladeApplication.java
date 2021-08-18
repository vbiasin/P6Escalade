package fr.OCP6Escalade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import fr.OCP6Escalade.DAO.RoleRepository;
import fr.OCP6Escalade.DAO.UserRepository;
import fr.OCP6Escalade.Entites.Role;
import fr.OCP6Escalade.Entites.User;*/

@SpringBootApplication
public class Ocp6EscaladeApplication {
	
	/*
	 * @Autowired private RoleRepository roleRepository;
	 * 
	 * @Autowired private UserRepository userRepository;
	 * 
	 * BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	 */
	public static void main(String[] args) {
		SpringApplication.run(Ocp6EscaladeApplication.class, args);
	
	}
	

	/*
	 * public void run(String... args) throws Exception { Role role1 =
	 * roleRepository.save(new Role("USER")); Role role2 = roleRepository.save(new
	 * Role("ADMIN")); Role role3 = roleRepository.save(new Role("SUPER")); User
	 * superUser = new User("admin", "Toto1234*") ;
	 * superUser.setPassword(bCryptPasswordEncoder.encode(superUser.getPassword()));
	 * ArrayList<Role> roles = new ArrayList<Role>(); roles.add(role1);
	 * roles.add(role2); 
	 * roles.add(role3);
	 *  superUser.setRole(roles);
	 * superUser = userRepository.save(superUser);
	 *  }
	 */


}
