package EX1;

import java.util.TreeSet;

public class GererGroupes {
    public static void main(String[] args) {
        TreeSet<Etudiant> g1 = new TreeSet<>();
        TreeSet<Etudiant> g2 = new TreeSet<>();
        

        g1.add(new Etudiant("FEHMI","12","100"));
        g1.add(new Etudiant("BACEM", "10","200"));
        g1.add(new Etudiant("ABIR", "14","500"));
        g1.add(new Etudiant("SAMIA", "16","800"));

        g2.add(new Etudiant("MOHAMED", "12","300"));
        g2.add(new Etudiant("BACEM", "11","200"));
        g2.add(new Etudiant("ALI", "13","400"));
        g2.add(new Etudiant("SAMIA", "16","800"));
        g2.add(new Etudiant("AHMED", "18","900"));    
        
        TreeSet<Etudiant> g3 = new TreeSet<>(g1);

        g3.addAll(g2);

        System.out.println("Ensemble g1 :");
        afficherEnsemble(g1);
        System.out.println("\nEnsemble g2 :");
        afficherEnsemble(g2);
        System.out.println("\nEnsemble g3 :");
        afficherEnsemble(g3);

        g2.retainAll(g1);

        System.out.println("\nEnsemble g2 rétention :");
        afficherEnsemble(g2);

        g1.removeAll(g2);

        System.out.println("\nEnsemble g1 après suppression de g2 :");
        afficherEnsemble(g1);

        TreeSet<Etudiant> g4 = new TreeSet<>(g1.subSet(g1.first(), false, g1.last(), false));

        System.out.println("\nEnsemble g4 :");
        afficherEnsemble(g4);

        System.out.println("\nLe 2eme étudiant de l ensemble g3.");
        System.out.println(g3.higher(g3.first()));    
        
        TreeSet<Etudiant> g5 = new TreeSet<Etudiant>();

        g5 = new TreeSet<Etudiant>(new ComparateurSelonNom());
        g5.addAll(g3);
        g5.add(new Etudiant("JAMEL", "15.0", "350"));

        System.out.println("\nUtilisation du ComparateurSelonNom");
        System.out.println(g5+"\n");


    }

    private static void afficherEnsemble(TreeSet<Etudiant> e) {
        for (Etudiant etudiant : e) {
            System.out.println(etudiant);
        }
    }
    
}
