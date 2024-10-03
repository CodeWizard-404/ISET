package Ex1;

public class Test {
    public static void main(String[] args) {



        Paire<Integer> paireEntiers = new Paire<>(10, 20);
        paireEntiers.afficher();

        Paire<String> paireChaines = new Paire<>("chaine1", "chaine2");
        paireChaines.afficher();

        Personne personne1 = new Personne("nom1", 10);
        Personne personne2 = new Personne("nom2", 25);
        Paire<Personne> pairePersonnes = new Paire<>(personne1, personne2);
        pairePersonnes.afficher();




        PaireBis<Double,Float> pair1 = new PaireBis<>(15.5, 2.4f);
        pair1.afficher();

        PaireBis<Double, Float> paire2 = new PaireBis<>(15.5, 2.4f);
        paire2.afficher();

        Personne personne = new Personne("Omar", 25);
        PaireBis<Integer, Personne> paire3 = new PaireBis<>(10, personne);
        paire3.afficher();  





        // Triplet<Integer,String,Double> tri1 = new Triplet<>(10,"Ali",15.3);
        // tri1.afficher();

        // Triplet<Integer,Integer,String> tri2 = new Triplet<>(23,15,"RSI");
        // tri2.afficher();

        Triplet<Integer, String> triplet1 = new Triplet<>(10, "Ali", 15);
        triplet1.afficher();

        Triplet<Integer, Integer> triplet2 = new Triplet<>(23, 15, 100);
        triplet2.afficher();
    }
}
