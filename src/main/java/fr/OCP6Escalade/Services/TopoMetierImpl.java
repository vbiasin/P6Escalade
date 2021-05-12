package fr.OCP6Escalade.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.OCP6Escalade.DAO.TopoRepository;
import fr.OCP6Escalade.DAO.UtilisateurRepository;
import fr.OCP6Escalade.Entites.Topo;
import fr.OCP6Escalade.Entites.Utilisateur;

@Service
@Transactional
public class TopoMetierImpl implements ITopoMetier {

	@Autowired
	TopoRepository topoRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Override
	public Topo enregistrerTopo(long idUtilisateur, Topo topo) throws Exception {
		Optional<Utilisateur> proprietaire = utilisateurRepository.findById(idUtilisateur);
		if(proprietaire.isEmpty())throw new Exception("L'utilisateur n'existe pas !");
		topo.setProprietaire(proprietaire.get());
		return topoRepository.save(topo);
	}

	@Override
	public Topo rendreDisponible(long idTopo) throws Exception {
		Optional<Topo> topo = topoRepository.findById(idTopo);
		if(topo.isEmpty()) throw new Exception("Le topo n'existe pas !");
		topo.get().setEstDispo(true);
		return topoRepository.saveAndFlush(topo.get());
	}

	@Override
	public List<Topo> listTopo() throws Exception {
		return null;//topoRepository.listTopo();
	}

	@Override
	public void supprimerTopo(long idTopo) throws Exception {
		Optional<Topo> topo = topoRepository.findById(idTopo);
		if(topo.isEmpty()) throw new Exception("Le topo n'existe pas !");
		topoRepository.delete(topo.get());
	}

}
