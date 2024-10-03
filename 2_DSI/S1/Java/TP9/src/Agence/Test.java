package Agence;

import location.*;

public class Test {
    public static void main(String[] args) {
        Agence agence = new Agence(10);

        Voiture voiture1 = new Voiture("Toyota", 2, 10000, 150, "bleu");
        Voiture voiture2 = new Voiture("BMW", 1, 10000, 150, "rouge");
        Voiture voiture3 = new Voiture("Nissan", 3, 10000, 150, "noir");

        VoitureUtilitaire utilitaire1 = new VoitureUtilitaire("Ford", 2, 12000, 120, "rouge", 1000);
        Bus bus1 = new Bus("Mercedes", 3, 15000, 40);

        agence.AjoutVeh(voiture1);
        agence.AjoutVeh(voiture2);
        agence.AjoutVeh(voiture3);
        agence.AjoutVeh(utilitaire1);
        agence.AjoutVeh(bus1);

        System.out.println("\nInventaire des véhicules dans l'agence :\n");
        agence.InventaireVeh();

        int numId = 2;
        int indice = agence.RechercheVeh(numId);
        if (indice != -1) {
            System.out.println("\nLe véhicule avec le numéro d'identification " + numId + " a été trouvé à l'indice " + indice);
        } else {
            System.out.println("\nLe véhicule avec le numéro d'identification " + numId + " n'a pas été trouvé.");
        }

        double totalTTC = agence.getTotalTTC();
        System.out.println("\nLe total des chiffres d'affaires TTC de tous les véhicules est : " + totalTTC);

        Agence agenceBus = agence.AgenceBus();
        System.out.println("\nAgence contenant seulement des bus :");
        agenceBus.InventaireVeh();

        String couleur = "bleu";
        Voiture[] voituresBleu = agence.listeVoitureParCouleur(couleur);
        System.out.println("\nVoitures de couleur " + couleur + " :");
        for (Voiture v : voituresBleu) {
            System.out.println(v.toString());
        }
    }
}
