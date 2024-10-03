public class Ouvrage {
    protected String titre;
    protected String dateCreation;
    protected boolean existe;

    public Ouvrage(String titre, String dateCreation) {
        this.titre = titre;
        this.dateCreation = dateCreation;
        existe = true;
    }

    public String getTitre() {
        return titre;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public String toString() {
        return "Titre: " + titre + ", Date de création: " + dateCreation + ", Existe: " + existe;
    }
}
