package Ex1;
// public class Triplet<T,U,V> {
//     private T x;
//     private U y;
//     private V z;

//     public Triplet(T first, U second, V third) {
//         this.x = first;
//         this.y = second;
//         this.z = third;
//     }

//     public void afficher() {
//         System.out.println("Premier = " + x + " Second = " + y + " Third = " + z);
//     }
// }

public class Triplet<T, U> extends PaireBis<T, U> {
    private T z;

    public Triplet(T premier, U second, T troisieme) {
        super(premier, second);
        this.z = troisieme;
    }

    public void afficher() {
        System.out.println("Premier = " + getX() + ", Second = " + getY() + ", Troisieme = " + z);
    }
}
