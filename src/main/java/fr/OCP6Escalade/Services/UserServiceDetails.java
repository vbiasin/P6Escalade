package fr.OCP6Escalade.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.OCP6Escalade.DAO.RoleRepository;
import fr.OCP6Escalade.DAO.UserRepository;
import fr.OCP6Escalade.Entites.Role;


@Service
public class UserServiceDetails implements UserDetailsService  {


	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {

	    Optional<fr.OCP6Escalade.Entites.User> user = userRepository.findByMail(mail);
	    

	    if (user.isEmpty())
        {
            throw new UsernameNotFoundException("Pas d'utilisateur avec l'identifiant : " + mail);
        }
	    
        
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.get().getRole()){
        	System.out.println(role.getName());
        	authorities.add(new SimpleGrantedAuthority(role.getName()));
        	}
     
		UserDetails result = new User(mail, user.get().getPassword(), authorities);
		System.out.println(mail + " User = " + user.get().getPassword() + " mot de passe " + authorities + " Role");
		return result;
	}
	 
}

	

