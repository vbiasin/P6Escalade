package fr.OCP6Escalade.Services;

import fr.OCP6Escalade.Entites.Contact;

public interface IContactMetier {
	
	public Contact ajouterContact(long idUtilisateur, Contact nouveauContact) throws Exception;
	public Contact modifierContact(long idContact, Contact nouveauContact) throws Exception;

}
