package com.DSI.TP1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DSI.TP1.Entities.Etudiant;
import com.DSI.TP1.Repositories.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements IServiceEtudiant{

	@Autowired
	EtudiantRepository etudiantReposetory;
	
	@Override
	public Etudiant findEtudiant(int id){
		Optional<Etudiant> etudiant= etudiantReposetory.findById(id);
		if(etudiant.isPresent())
			return etudiant.get();
		else
			return null;
	}

	@Override
	public boolean saveEtudiant(Etudiant etudiant) {
		if(etudiantReposetory.save(etudiant) !=null)
			return true;
		else
			return false;
	}
	@Override
	public boolean deletEtudiant(int id) {
		etudiantReposetory.deleteById (id);
		return !etudiantReposetory.existsById(id);
	}
	@Override
	public Etudiant updateEtudiant(Etudiant etudiant, int id){
		etudiant.setCode(id) ;
		etudiantReposetory.save (etudiant) ;
		return etudiantReposetory.findById(id).get();
	}

	@Override
	public List<Etudiant> getAllEtudiant() {
	    return etudiantReposetory.findAll();
	}

	@Override
	public List<Etudiant> findEtudiantsParNom(String nom) {
		return etudiantReposetory.findByNom(nom);
	}
}
