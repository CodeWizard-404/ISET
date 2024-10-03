package Produit;

public class ArticleLot extends Article {
    private int nombrePieces;
    private double remise;

    public ArticleLot(String code, String designation, double prix, double tva, String famille, int nombrePieces, double remise) {
        super(code, designation, prix, tva, famille);
        this.nombrePieces = nombrePieces;
        this.remise = remise;
    }

    public int getNombrePieces() {
        return nombrePieces;
    }

    public double getRemise() {
        return remise;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nombre de Pieces: " + nombrePieces + ", Remise: " + remise;
    }

    @Override
    public double PrixTTC() {
        return super.PrixTTC() * (1 - remise);
    }
}
