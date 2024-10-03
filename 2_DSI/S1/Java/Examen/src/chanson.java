public class chanson {
    private String titre;
    private int duree;

    public chanson(String titre, int duree) {
        this.titre = titre;
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public int getDuree() {
        return duree;
    }

    public String toString() {
        return "Chanson [titre=" + titre + ", duree=" + duree + "]";
    }
}
