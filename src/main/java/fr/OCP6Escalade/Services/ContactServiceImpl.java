package fr.OCP6Escalade.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.OCP6Escalade.DAO.ContactRepository;
import fr.OCP6Escalade.DAO.UserRepository;
import fr.OCP6Escalade.Entites.Contact;
import fr.OCP6Escalade.Entites.User;

@Service
@Transactional
public class ContactServiceImpl implements IContactService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ContactRepository contactRepository;
	
	@Override
	public Contact addContact(long idUser, Contact newContact) throws Exception {
		Optional<User> user = userRepository.findById(idUser);
		if(user.isEmpty()) throw new Exception("User inexistant !");
		if(user.get().getContact()!=null) throw new Exception("Un contact est déjà associé à cet utilisateur !");
		user.get().setContact(newContact);
		contactRepository.save(newContact);
		userRepository.saveAndFlush(user.get());
		return newContact;
	}

	@Override
	public Contact modifyContact(long idContact, Contact newContact) throws Exception {
		Optional<Contact> contact = contactRepository.findById(idContact);
		if(contact.isEmpty())throw new Exception("Le contact n'existe pas !");
		contact.get().setAddress(newContact.getAddress());
		contact.get().setLastName(newContact.getLastName());
		//contact.get().setFirstName(newContact.getFirstName());
		return contactRepository.saveAndFlush(contact.get());
	}

}
