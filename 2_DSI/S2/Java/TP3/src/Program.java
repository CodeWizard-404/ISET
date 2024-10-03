import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClasseEtudiants classeDSI2 = new ClasseEtudiants("DSI2");

        int choice;
        do {
            System.out.println("--------------- MENU ---------------");
            System.out.println("1- Ajouter un étudiant");
            System.out.println("2- Insérer un étudiant à une position donnée");
            System.out.println("3- Ajouter un étudiant en début de la liste");
            System.out.println("4- Consulter un étudiant en fournissant son NCE");
            System.out.println("5- Consulter un étudiant se trouvant à une position donnée");
            System.out.println("6- Supprimer un étudiant connaissant son NCE");
            System.out.println("7- Afficher la liste des étudiants");
            System.out.println("8- Vider la liste");
            System.out.println("9- Quitter");

            System.out.print("Choix : ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    Etudiant etudiant = creerEtudiant();
                    classeDSI2.ajouterEtudiant(etudiant);
                    break;
                case 2:
                    System.out.print("Position : ");
                    int index = scanner.nextInt();
                    etudiant = creerEtudiant();
                    classeDSI2.ajouterEtudiant(index, etudiant);
                    break;
                case 3:
                    etudiant = creerEtudiant();
                    classeDSI2.ajouterAuDebut(etudiant);
                    break;
                case 4:
                    System.out.print("NCE : ");
                    String nCE = scanner.nextLine();
                    Etudiant resultEtudiant = classeDSI2.chercherEtudiant(nCE);
                    if (resultEtudiant != null) {
                        System.out.println(resultEtudiant.toString());
                    } else {
                        System.out.println("Étudiant non trouvé.");
                    }
                    break;
                case 5:
                    System.out.print("Position : ");
                    int position = scanner.nextInt();
                    resultEtudiant = classeDSI2.chercherEtudiant(position);
                    if (resultEtudiant != null) {
                        System.out.println(resultEtudiant.toString());
                    } else {
                        System.out.println("Étudiant non trouvé.");
                    }
                    break;
                case 6:
                    System.out.print("NCE : ");
                    nCE = scanner.nextLine();
                    if (classeDSI2.SupprimerEtudiant(nCE)) {
                        System.out.println("Étudiant supprimé avec succès.");
                    } else {
                        System.out.println("Étudiant non trouvé.");
                    }
                    break;
                case 7:
                    classeDSI2.afficherListeEtudiant();
                    break;
                case 8:
                    classeDSI2.viderEtudiants();
                    System.out.println("Liste des étudiants vidée.");
                    break;
                case 9:
                    System.out.println("Programme terminé.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }

        } while (choice != 9);

        scanner.close();
    }

    public static Etudiant creerEtudiant() {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

        System.out.print("NCE : ");
        String nCE = scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Moyenne : ");
        float moyenne = scanner.nextFloat();

        return new Etudiant(nCE, nom, moyenne);
    }
}
