package fr.OCP6Escalade.Services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.OCP6Escalade.DAO.UserRepository;
import fr.OCP6Escalade.Entites.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User register(User visitor) throws Exception {
		Optional<User> newUser = userRepository.findByMail(visitor.getMail());
		if(!newUser.isEmpty()) throw new Exception("Un utilisateur avec cette adresse mail existe déjà !");
		visitor.setPassword(bCryptPasswordEncoder.encode(visitor.getPassword()));
		return userRepository.save(visitor);
	}

	@Override
	public boolean isValid(User visitor) throws Exception {
		Optional<User> newUser = userRepository.findByMailAndPassword(visitor.getMail(), visitor.getPassword());
		if(newUser.isEmpty()) {
			throw new Exception("Login ou mot de passe incorrect!");
		}
		return true;
	}
	
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

	@Override
	public User getUser(String mail) throws Exception {
		Optional<User>connectedUser = userRepository.findByMail(mail);
		if(connectedUser.isEmpty()) throw new Exception("Cette adresse mail n'a pas été trouvée !");
		return connectedUser.get();
	}

}
