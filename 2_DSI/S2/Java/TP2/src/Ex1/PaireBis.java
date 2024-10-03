package Ex1;
public class PaireBis <T,U>{
    private T x;
    private U y;

    public PaireBis(T first, U second) {
        this.x = first;
        this.y = second;
    }

    

    public void afficher() {
        System.out.println("Premier = " + x + ", Second = " + y);
    }

    public T getX() {
        return x;
    }
    public U getY() {
        return y;
    }
}
