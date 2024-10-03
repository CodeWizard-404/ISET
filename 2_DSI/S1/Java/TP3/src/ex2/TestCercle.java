package ex2;


public class TestCercle {
    public static void main(String[] args) {
        Point centre = new Point(3, 4);
        Cercle cercle = new Cercle(centre, 5);
        System.out.println("Cercle: " + cercle);
        System.out.println("Surface du cercle: " + cercle.Surface());

        cercle.Translater(2, 2);
        System.out.println("Cercle après translation: " + cercle);
    }
}

