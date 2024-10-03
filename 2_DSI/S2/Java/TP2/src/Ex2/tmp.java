package Ex2;

public class tmp {
    private int T[] = new int[100];
    private int sommet;

    public tmp() {
        sommet = -1;
        
    }

    tmp(int t) {
        sommet = -1;
    }

    public void empiler(int elt) {
        sommet++;
        T[sommet] = elt;
    }

    public void depiler() {
        sommet--;
    }

    public int som() {
        return T[sommet];
    }

    public void vider() {
        sommet = -1;
    }

    public void afficher() {
        for (int i = 0; i <= sommet; i++)
            System.out.println(T[i] + " ");
    }

    public boolean pileVide() {
        return (sommet == -1);
    }

    public boolean pilePleine() {
        return (sommet == T.length - 1);
    }
}