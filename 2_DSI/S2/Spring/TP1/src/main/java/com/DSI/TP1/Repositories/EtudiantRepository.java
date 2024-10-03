package com.DSI.TP1.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DSI.TP1.Entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
	List<Etudiant> findByNom(String nom);

}


