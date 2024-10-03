package Ex2;
public class Pile<T> {
    private T[] T;
    private int sommet;
    private int tailleMax;

    @SuppressWarnings("unchecked")
    public Pile(int tailleMax) {
        this.tailleMax = tailleMax;
        T = (T[]) new Object[tailleMax];
        sommet = -1;
    }

    public void empiler(T elt) {
        if (!pilePleine()) {
            sommet++;
            T[sommet] = elt;
        } else {
            System.out.println("La pile est pleine !");
        }
    }

    public void depiler() {
        if (!pileVide()) {
            sommet--;
        } else {
            System.out.println("La pile est vide !");
        }
    }

    public T som() {
        if (!pileVide()) {
            return T[sommet];
        } else {
            System.out.println("La pile est vide !");
            return null;
        }
    }

    public void afficher() {
        if (!pileVide()) {
            for (int i = 0; i <= sommet; i++) {
                System.out.println(T[i] + " ");
            }
        } else {
            System.out.println("La pile est vide !");
        }
    }

    public void vider() {
        sommet = -1;
    }

    public boolean pileVide() {
        return (sommet == -1);
    }

    public boolean pilePleine() {
        return (sommet == tailleMax - 1);
    }
}
