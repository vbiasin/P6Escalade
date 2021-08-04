package fr.OCP6Escalade.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.OCP6Escalade.DAO.TopoRepository;
import fr.OCP6Escalade.DAO.UserRepository;
import fr.OCP6Escalade.Entites.Topo;
import fr.OCP6Escalade.Entites.User;

@Service
@Transactional
public class TopoServiceImpl implements ITopoService {

	@Autowired
	TopoRepository topoRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Topo saveTopo(long idUser, Topo topo) throws Exception {
		Optional<User> owner = userRepository.findById(idUser);
		if(owner.isEmpty())throw new Exception("L'utilisateur n'existe pas !");
		topo.setOwner(owner.get());
		return topoRepository.save(topo);
	}

	@Override
	public Topo getAvailable(long idTopo) throws Exception {
		Optional<Topo> topo = topoRepository.findById(idTopo);
		if(topo.isEmpty()) throw new Exception("Le topo n'existe pas !");
		topo.get().setAvailable(true);
		return topoRepository.saveAndFlush(topo.get());
	}

	@Override
	public Page<Topo> listTopos(int pages, int size) throws Exception {
		return topoRepository.listTopos(PageRequest.of(pages, size));
	}

	@Override
	public void removeTopo(long idTopo) throws Exception {
		Optional<Topo> topo = topoRepository.findById(idTopo);
		if(topo.isEmpty()) throw new Exception("Le topo n'existe pas !");
		topoRepository.delete(topo.get());
	}

	@Override
	public Page<Topo> myTopos(long idOwner,int pages, int size) throws Exception {
		return topoRepository.myTopos(idOwner,PageRequest.of(pages, size));
	}

}
