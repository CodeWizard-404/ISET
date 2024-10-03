package Partie1;

public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point("A", 1, 2);
        Point p2 = new Point("B", 3, 4);

        System.out.println(" p1: " + p1.toString());
        System.out.println(" p2: " + p2.toString());

        p1.Translation(2, 3);
        System.out.println("Translation (2,3) de p1:   " + p1.toString());

        p2.TranslHoriz(1);
        System.out.println("TranslHoriz (1) de p2:     " + p2.toString());

        p2.TranslVert(1);
        System.out.println("TranslVert (1) de p2:      " + p2.toString());

        p1.Affiche();
        p2.Affiche();

        System.out.println(" -> p1 & p2 coincide? " + p1.Coincide(p2));

        p1.setAbscisse(5);
        p2.setOrdonnee(6);

        System.out.println("- p1: " + p1.toString());
        System.out.println("- p2: " + p2.toString());
    }
}
