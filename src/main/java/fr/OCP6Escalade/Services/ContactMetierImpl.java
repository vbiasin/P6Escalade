package fr.OCP6Escalade.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.OCP6Escalade.DAO.ContactRepository;
import fr.OCP6Escalade.DAO.UtilisateurRepository;
import fr.OCP6Escalde.Entites.Contact;
import fr.OCP6Escalde.Entites.Utilisateur;

public class ContactMetierImpl implements IContactMetier {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	ContactRepository contactRepository;
	
	@Override
	public Contact ajouterContact(long idUtilisateur, Contact nouveauContact) throws Exception {
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(idUtilisateur);
		if(utilisateur.isEmpty()) throw new Exception("Utilisateur inexistant !");
		if(utilisateur.get().getContact()!=null) throw new Exception("Un contact est déjà associé à cet utilisateur !");
		utilisateur.get().setContact(nouveauContact);
		utilisateurRepository.saveAndFlush(utilisateur.get());		
		return nouveauContact;
	}

	@Override
	public Contact modifierContact(long idContact, Contact nouveauContact) throws Exception {
		Optional<Contact> contact = contactRepository.findById(idContact);
		if(contact.isEmpty())throw new Exception("Le contact n'existe pas !");
		contact.get().setAdresse(nouveauContact.getAdresse());
		contact.get().setNom(nouveauContact.getNom());
		contact.get().setPrenom(nouveauContact.getPrenom());
		return contactRepository.saveAndFlush(contact.get());
	}

}
