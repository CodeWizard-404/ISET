package location;

public class Voiture extends Vehicule {
    private int puissance;
    private String couleur;

    public Voiture(String marque, int numId, double chiffreAffairesHT, int puissance, String couleur) {
        super(marque, numId, chiffreAffairesHT);
        this.puissance = puissance;
        this.couleur = couleur;
    }

    public double ChiffreAffairesTTC() {
        return getChiffreAffairesHT() * 1.15;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String toString() {
        return "Voiture [" +
                " -- marque='" + getMarque() + '\'' +
                " -- Id=" + getId() +
                " -- chiffreAffairesHT=" + getChiffreAffairesHT() +
                " -- puissance=" + puissance +
                " -- couleur='" + couleur + '\'' +
                ']';
    }

    public void Edition() {
        System.out.println(toString());
    }

}
