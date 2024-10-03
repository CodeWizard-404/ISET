package EX6;

public class Produit {
    private String reference;
    private int quantite;
    private double prix;
    private double taux;

    public void InitProd(String i, int q, double p, double t) {
        reference = i;
        quantite = q;
        prix = p;
        if ((t>=0)&&(t<=100)) {
            taux = t;
        }
    }

    public void ChangerTaux(double t) {
        taux = t;
    }

    public double CalculPrix() {
        double prixTTC = prix * (1 + taux / 100);
        return prixTTC;
    }

    public void Affiche() {
        System.out.println("Référence : " + reference + ", Quantité : " + quantite +", Prix Hors Taxe : " + prix +", Taux de Taxe : " + taux + "%");
    }
}
