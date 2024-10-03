public class Abonne extends Personne {
    private int numAbonnement;
    private Ouvrage ouvragePris;

    public Abonne(int numId, String nom, int numAbonnement, Ouvrage ouvragePris) {
        super(numId, nom);
        this.numAbonnement = numAbonnement;
        this.ouvragePris = ouvragePris;
    }

    public int getNumAbonnement() {
        return numAbonnement;
    }

    public Ouvrage getOuvragePris() {
        return ouvragePris;
    }

    public String toString() {
        return super.toString() + ", Numéro d'abonnement: " + numAbonnement + ", Ouvrage pris: " + ouvragePris.getTitre();
    }

    public void setOuvragePris(Ouvrage ouvrage) {
    }
}
