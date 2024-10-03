public abstract class oeuvre {
    protected String genre;
    protected String titre;

    public oeuvre(String genre, String titre) {
        this.genre = genre;
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public abstract int getDuree();

    @Override
    public String toString() {
        return "Oeuvre [genre=" + genre + ", titre=" + titre + "]";
    }

    public abstract void Affiche();    
    public abstract boolean estDisque();

}
