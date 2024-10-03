package com.DSI.TP1;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DSI.TP1.Entities.Adresse;
import com.DSI.TP1.Entities.EtatLivre;
import com.DSI.TP1.Entities.Etudiant;
import com.DSI.TP1.Entities.Livre;
import com.DSI.TP1.services.IServiceEtudiant;
import com.DSI.TP1.services.IServiceLivre;

@SpringBootApplication
public class Tp1Application implements CommandLineRunner {

    @Autowired
    private IServiceEtudiant serviceEtudiant;

    @Autowired
    private IServiceLivre serviceLivre;

    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args);
    }

    @SuppressWarnings("unused")
	@Override
    public void run(String... args) throws Exception {

        // Ajouter deux étudiants dans la table « etudiant » avec leurs adresses

        Adresse adresse1 = new Adresse(101, "Rue Test1", "Rades", "2040");
        Adresse adresse2 = new Adresse(202, "Rue Test2", "Charguia", "2070");

        Etudiant etudiant1 = new Etudiant("Etudiant1", "Nom1", LocalDate.of(2000, 2, 12), adresse1);
        Etudiant etudiant2 = new Etudiant("Etudiant2", "Nom2", LocalDate.of(2001, 11, 5), adresse2);

        serviceEtudiant.saveEtudiant(etudiant1);
        serviceEtudiant.saveEtudiant(etudiant2);

        // Afficher les étudiants ainsi que leurs adresses

        System.out.println("\n\nListe des étudiants :");
        serviceEtudiant.getAllEtudiant().toString();

        // Ajouter deux états de livres

        EtatLivre disponibleEmprunte = new EtatLivre(true, true);
        EtatLivre disponibleNonEmprunte = new EtatLivre(true, false);

        // Similaire pour les autres repositories

        //  Ajouter trois livres dans la table « livre »

        Livre livre1 = new Livre("123456789", "Livre 1", "Auteur 1", LocalDate.now(), 5);
        Livre livre2 = new Livre("987654321", "Livre 2", "Auteur 2", LocalDate.now(), 3);
        Livre livre3 = new Livre("456789123", "Livre 3", "Auteur 3", LocalDate.now(), 7);

        serviceLivre.saveLivre(livre1);
        serviceLivre.saveLivre(livre2);
        serviceLivre.saveLivre(livre3);

        // Afficher les livres ainsi que leurs états

        System.out.println("\n\nListe des livres :");
        serviceLivre.getAllLivre().toString();

        // Emprunter le 1er et le 3ème livre au 1er étudiant

        etudiant1.getLivres().add(livre1);
        etudiant1.getLivres().add(livre3);

        serviceEtudiant.updateEtudiant(etudiant1, etudiant1.getCode());

        // Afficher les emprunts réalisés par l'étudiant n°1

        System.out.println("\n\nEmprunts réalisés par l'étudiant n°1 :");
        //System.out.println(serviceEtudiant.findEtudiant(etudiant1.getCode()).getLivres());
        System.out.println("\n\n");
    }
}
