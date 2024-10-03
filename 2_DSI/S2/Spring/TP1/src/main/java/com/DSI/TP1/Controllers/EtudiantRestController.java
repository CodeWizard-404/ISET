package com.DSI.TP1.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DSI.TP1.services.*;
import com.DSI.TP1.Entities.*;

@RestController
public class EtudiantRestController {

    @Autowired
    IServiceEtudiant iServiceEtudiant;

    @GetMapping("/etudiants")
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = iServiceEtudiant.getAllEtudiant();
        return ResponseEntity.ok().body(etudiants);
    }

    @GetMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") int id) {
        Etudiant etudiant = iServiceEtudiant.findEtudiant(id);
        if (etudiant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(etudiant);
    }

    @GetMapping("/etudiantsByLastName")
    public ResponseEntity<List<Etudiant>> getEtudiantsByLastName(@RequestParam("nom") String nom) {
        List<Etudiant> etudiants = iServiceEtudiant.findEtudiantsParNom(nom);
        if (etudiants.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(etudiants);
    }

    @PostMapping("/etudiants")
    public ResponseEntity<String> addEtudiant(@RequestBody Etudiant etudiant) {
        boolean saved = iServiceEtudiant.saveEtudiant(etudiant);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Etudiant added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add etudiant");
        }
    }

    @PutMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable("id") int id) {
        Etudiant updatedEtudiant = iServiceEtudiant.updateEtudiant(etudiant, id);
        if (updatedEtudiant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedEtudiant);
    }

    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable("id") int id) {
        boolean deleted = iServiceEtudiant.deletEtudiant(id);
        if (deleted) {
            return ResponseEntity.ok().body("Etudiant deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
