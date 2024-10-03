package ex2;
import java.util.Scanner;

public class TestTabCercle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Combien de cercles souhaitez-vous créer ? ");
        int n = scanner.nextInt();

        Cercle[] cercles = new Cercle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Cercle " + (i + 1));
            System.out.print("Entrez l'abscisse du centre : ");
            int abscisse = scanner.nextInt();
            System.out.print("Entrez l'ordonnée du centre : ");
            int ordonnee = scanner.nextInt();
            System.out.print("Entrez le rayon : ");
            int rayon = scanner.nextInt();

            cercles[i] = new Cercle(new Point(abscisse, ordonnee), rayon);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Cercle " + (i + 1) + ": " + cercles[i]);
            System.out.println("Surface du cercle : " + cercles[i].Surface());
        }

        double surfaceTotale = 0.0;
        for (Cercle cercle : cercles) {
            surfaceTotale += cercle.Surface();
        }

        System.out.println("Surface totale de tous les cercles : " + surfaceTotale);
    }
}
