package fr.OCP6Escalade.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.OCP6Escalde.Entites.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
