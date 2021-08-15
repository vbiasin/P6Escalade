package fr.OCP6Escalade.Services;

import java.util.Collection;


import fr.OCP6Escalade.Entites.Role;


public interface IRoleService {
	
	public void addRoleToUser (String mail, long idRole) throws Exception;
	public void removeRoleFromUser (String mail, long idRole) throws Exception;

}
