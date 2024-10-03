import java.util.Scanner;

class Etudiant {
    int cin;
    String nom;
    double Moy1;
    double Moy2;
    double moyAnnuelle;

    public void saisirInfo() {
        Scanner S = new Scanner(System.in);

        System.out.print("Entrez le CIN de l'étudiant : ");
        cin = S.nextInt();
        S.nextLine();

        System.out.print("Entrez le nom de l'étudiant : ");
        nom = S.nextLine();

        System.out.print("Entrez la moy1 : ");
        Moy1 = S.nextDouble();

        System.out.print("Entrez la moy2 : ");
        Moy2 = S.nextDouble();

        moyAnnuelle = (Moy1 + Moy2) / 2.0;

        S.close();
    }
}

class Admission {
    public static void main(String[] args) {
        Etudiant E = new Etudiant();
        E.saisirInfo();

        if (E.moyAnnuelle >= 10.0) {
            System.out.println(E.nom + "de CIN " + E.cin + " est admis avec une moy de " + E.moyAnnuelle);
        } else {
            System.out.println(E.nom + "de CIN " + E.cin + " n'est pas admis avec une moy de " + E.moyAnnuelle);
        }
    }
}
