public class Video extends Ouvrage {
    private String editeur;
    private double duree;

    public Video(String titre, String dateCreation, String editeur, double duree) {
        super(titre, dateCreation);
        this.editeur = editeur;
        this.duree = duree;
    } 

    public String getEditeur() {
        return editeur;
    }

    public double getDuree() {
        return duree;
    }

    public String toString() {
        return super.toString() + ", Éditeur: " + editeur + ", Durée: " + duree + " minutes";
    }
}
