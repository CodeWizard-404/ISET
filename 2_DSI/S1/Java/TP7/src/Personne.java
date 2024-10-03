public class Personne {
    private int numId;
    private String nom;

    public Personne(int numId, String nom) {
        this.numId = numId;
        this.nom = nom;
    }

    public int getNumId() {
        return numId;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return "Numéro d'identité: " + numId + ", Nom: " + nom;
    }
}
