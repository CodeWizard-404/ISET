package Ex4;

import java.util.ArrayList;

public class Pile<T> {
    private ArrayList<T> elements;

    public Pile() {
        elements = new ArrayList<>();
    }

    public void empiler(T elt) {
        elements.add(elt);
    }

    public void depiler() {
        if (!pileVide()) {
            elements.remove(elements.size() - 1);
        } else {
            System.out.println("La pile est vide !");
        }
    }

    public T sommet() {
        if (!pileVide()) {
            return elements.get(elements.size() - 1);
        } else {
            System.out.println("La pile est vide !");
            return null; 
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
