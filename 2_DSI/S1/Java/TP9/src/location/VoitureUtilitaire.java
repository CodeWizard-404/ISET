package location;

public class VoitureUtilitaire extends Voiture {
    private double chargeUtile;

    public VoitureUtilitaire(String marque, int numId, double chiffreAffairesHT, int puissance, String couleur, double chargeUtile) {
        super(marque, numId, chiffreAffairesHT, puissance, couleur);
        this.chargeUtile = chargeUtile;
    }

    public double ChiffreAffairesTTC() {
        return getChiffreAffairesHT() * 1.15 + 0.015 * chargeUtile;
    }

    public double getChargeUtile() {
        return chargeUtile;
    }

    public void setChargeUtile(double chargeUtile) {
        this.chargeUtile = chargeUtile;
    }

    public String toString() {
        return "Voiture Utilitaire [" +
                " -- marque='" + getMarque() + '\'' +
                " -- Id=" + getId() +
                " -- chiffre Affaires HT=" + getChiffreAffairesHT() +
                " -- puissance=" + getPuissance() +
                " -- couleur='" + getCouleur() + '\'' +
                " -- charge Utile=" + chargeUtile +
                ']';
    }

    public void Edition() {
        System.out.println(toString());
    }

}
