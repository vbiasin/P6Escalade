package fr.OCP6Escalade.Services;

import java.util.Optional;

import fr.OCP6Escalade.Entites.User;

public interface IUserService {
	
	public User register(User visitor) throws Exception;
	public boolean isValid(User visitor) throws Exception;
	public User getUser(String mail) throws Exception;

}
