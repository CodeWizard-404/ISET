package Ex1;
public class Paire<T> {
    private T x, y;

    public Paire(T first, T second) {
        this.x = first;
        this.y = second;
    }

    public void afficher() {
        System.out.println("Premier = " + x + " Second = " + y);
    }
}
