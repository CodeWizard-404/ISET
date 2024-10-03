package com.DSI.TP1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DSI.TP1.Entities.Livre;
import com.DSI.TP1.Repositories.LivreRepository;

@Service
public class LivreServiceImpl implements IServiceLivre{

	@Autowired
	LivreRepository livreReposetory;
	
	@Override
	public Livre findLivre(int id){
		Optional<Livre> Livre= livreReposetory.findById(id);
		if(Livre.isPresent())
			return Livre.get();
		else
			return null;
	}

	@Override
	public boolean saveLivre(Livre Livre) {
		if(livreReposetory.save(Livre) !=null)
			return true;
		else
			return false;
	}
	@Override
	public boolean deletLivre(int id) {
		livreReposetory.deleteById (id);
		return !livreReposetory.existsById(id);
	}
	@Override
	public Livre updateLivre(Livre Livre, int id){
		Livre.setCode(id) ;
		livreReposetory.save (Livre) ;
		return livreReposetory.findById(id).get();
	}

	@Override
	public List<Livre> getAllLivre() {
	    return livreReposetory.findAll();
	}
}
