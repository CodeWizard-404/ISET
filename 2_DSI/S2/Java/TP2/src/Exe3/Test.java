import java.util.Scanner;

public class TestPile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pile pile = new Pile();

        int choix;
        int valeur;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Empiler");
            System.out.println("2. Dépiler");
            System.out.println("3. Afficher la valeur au sommet");
            System.out.println("4. Afficher la pile");
            System.out.println("5. Vider la pile");
            System.out.println("6. Quitter");

            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrez la valeur à empiler : ");
                    valeur = scanner.next();
                    pile.empiler(valeur);
                    break;
                case 2:
                    pile.depiler();
                    break;
                case 3:
                    System.out.println("La valeur au sommet est : " + pile.sommet());
                    break;
                case 4:
                    System.out.println("Contenu de la pile : ");
                    pile.afficher();
                    break;
                case 5:
                    pile.vider();
                    System.out.println("La pile a été vidée.");
                    break;
                case 6:
                    System.out.println("Programme terminé.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        } while (choix != 6);

        scanner.close();
    }
}
