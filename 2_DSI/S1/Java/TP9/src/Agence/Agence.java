package Agence;

import java.util.ArrayList;
import java.util.List;

import location.Bus;
import location.IlocationBus;
import location.Vehicule;
import location.Voiture;

public class Agence {
    private Vehicule[] ListVeh;
    private int NbreVeh;
    private int capaciteMax;

    public Agence(int capaciteMax) {
        this.capaciteMax = capaciteMax;
        this.ListVeh = new Vehicule[capaciteMax];
        this.NbreVeh = 0;
    }

    public int RechercheVeh(int numId) {
        for (int i = 0; i < NbreVeh; i++) {
            if (ListVeh[i].getId() == numId) {
                return i;
            }
        }
        return -1;
    }

    public boolean AjoutVeh(Vehicule v) {
        if (NbreVeh < capaciteMax) {
            if (RechercheVeh(v.getId()) == -1) {
                ListVeh[NbreVeh] = v;
                NbreVeh++;
                trierListVeh();
                return true;
            }
        }
        return false;
    }

    private void trierListVeh() {
        for (int i = 0; i < NbreVeh - 1; i++) {
            for (int j = i + 1; j < NbreVeh; j++) {
                if (ListVeh[i].getId() > ListVeh[j].getId()) {
                    Vehicule T = ListVeh[i];
                    ListVeh[i] = ListVeh[j];
                    ListVeh[j] = T;
                }
            }
        }
    }

    public void SupprimVeh(int numId) {
        int in = RechercheVeh(numId);
        if (in != -1) {
            for (int i = in; i < NbreVeh - 1; i++) {
                ListVeh[i] = ListVeh[i + 1];
            }
            NbreVeh--;
        }
    }

    public void InventaireVeh() {
        for (int i = 0; i < NbreVeh; i++) {
            System.out.println(ListVeh[i].toString());
        }
    }

    public double getTotalTTC() {
        double totalTTC = 0;
        for (int i = 0; i < NbreVeh; i++) {
            totalTTC += ListVeh[i].ChiffreAffairesTTC();
        }
        return totalTTC;
    }

    public double getTotalTaxe() {
        double totalTaxe = 0;
        for (Vehicule vehicule : ListVeh) {
            if (vehicule instanceof IlocationBus) {
                totalTaxe += ((IlocationBus) vehicule).AssuranceParLocation();
            }
        }
        return totalTaxe;
    }

    public Voiture[] listeVoitureParCouleur(String couleur) {
        List<Voiture> voituresCouleur = new ArrayList<>();

        for (Vehicule vehicule : ListVeh) {
            if (vehicule instanceof Voiture && ((Voiture) vehicule).getCouleur().equals(couleur)) {
                voituresCouleur.add((Voiture) vehicule);
            }
        }

        return voituresCouleur.toArray(new Voiture[0]);
    }

    public Agence AgenceBus() {
        Agence agenceBus = new Agence(capaciteMax);
        for (Vehicule vehicule : ListVeh) {
            if (vehicule instanceof Bus) {
                agenceBus.AjoutVeh(vehicule);
            }
        }
        return agenceBus;
    }

}
