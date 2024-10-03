package Exe3;

import java.util.ArrayList;

public class Pile {
    private ArrayList<Integer> elements;

    public Pile() {
        elements = new ArrayList<>();
    }

    public void empiler(int elt) {
        elements.add(elt);
    }

    public void depiler() {
        if (!pileVide()) {
            elements.remove(elements.size() - 1);
        } else {
            System.out.println("La pile est vide !");
        }
    }

    public int sommet() {
        if (!pileVide()) {
            return elements.get(elements.size() - 1);
        } else {
            System.out.println("La pile est vide !");
            return -1; 
        }
    }

    public void afficher() {
        if (!pileVide()) {
            for (int i = elements.size() - 1; i >= 0; i--) {
                System.out.println(elements.get(i) + " ");
            }
        } else {
            System.out.println("La pile est vide !");
        }
    }

    public void vider() {
        elements.clear();
    }

    public boolean pileVide() {
        return elements.isEmpty();
    }
}

