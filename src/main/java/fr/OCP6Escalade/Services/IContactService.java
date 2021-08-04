package fr.OCP6Escalade.Services;

import fr.OCP6Escalade.Entites.Contact;

public interface IContactService {
	
	public Contact addContact(long idUser, Contact contact) throws Exception;
	public Contact modifyContact(long idContact, Contact newContact) throws Exception;

}
