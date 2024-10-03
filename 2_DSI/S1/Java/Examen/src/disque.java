import java.util.ArrayList;

public class disque implements INombre {
    private ArrayList<chanson> tabChansons;
    private int nombreChansons;
    private String genre;

    public disque(String genre, int tailleMax) {
        this.genre = genre;
        this.tabChansons = new ArrayList<>(tailleMax);
        this.nombreChansons = 0;
    }

    public boolean ajoutChanson(chanson c) {
        if (!tabChansons.contains(c) && c.getTitre().equals(genre)) {
            tabChansons.add(c);
            nombreChansons++;
            return true;
        }
        return false;
    }

    public chanson getChanson(String titre) {
        for (chanson c : tabChansons) {
            if (c.getTitre().equals(titre)) {
                return c;
            }
        }
        return null;
    }

    public chanson[] getTabChansons() {
        return tabChansons.toArray(new chanson[0]);
    }

    @Override
    public int getNombreChansons() {
        return nombreChansons;
    }

    public void Affiche() {
        for (chanson c : tabChansons) {
            System.out.println(c);
        }
    }

    public boolean estDisque() {
        return true;
    }
}
