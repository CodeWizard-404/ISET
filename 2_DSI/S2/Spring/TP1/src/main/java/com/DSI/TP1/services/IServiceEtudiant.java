package com.DSI.TP1.services;

import java.util.List;

import com.DSI.TP1.Entities.Etudiant;

public interface IServiceEtudiant {

    public List<Etudiant> getAllEtudiant();
    public Etudiant findEtudiant(int id);
    public boolean saveEtudiant(Etudiant etudiant);
    public boolean deletEtudiant(int id);
    public Etudiant updateEtudiant(Etudiant etudiant,int id);
	public List<Etudiant> findEtudiantsParNom(String nom);
}