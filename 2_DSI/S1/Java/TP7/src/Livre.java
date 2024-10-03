public class Livre extends Ouvrage {
    private String auteur;

    public Livre(String titre, String dateCreation , String auteur) {
        super(titre, dateCreation);
        this.auteur = auteur;
    }

    public String getAuteur() {
        return auteur;
    }

    public String toString() {
        return super.toString() + ", Auteur: " + auteur;
    }
}
