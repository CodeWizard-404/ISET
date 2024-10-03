import java.util.ArrayList;

public class artiste {
    private int identifiant;
    private String nom;
    private String nationalite;
    private int nombreOeuvres;
    private oeuvre[] tabOeuvres;

    public artiste(int identifiant, String nom, String nationalite, int tailleMax) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombreOeuvres = 0;
        this.tabOeuvres = new oeuvre[tailleMax];
    }

    public boolean produire(oeuvre o) {
        if (nombreOeuvres < tabOeuvres.length) {
            tabOeuvres[nombreOeuvres] = o;
            nombreOeuvres++;
            return true;
        }
        return false;
    }
    

    public void AfficheArtiste() {
        System.out.println("Artiste [identifiant=" + identifiant + ", nom=" + nom + ", nationalite=" + nationalite
                + ", nombreOeuvres=" + nombreOeuvres + "]");
        for (oeuvre o : tabOeuvres) {
            if (o != null) {
                System.out.println(o);
            }
        }
    }

    public int nombreDisques() {
        int count = 0;
        for (oeuvre o : tabOeuvres) {
            if (o != null && o.estDisque()) {
                count++;
            }
        }
        return count;
    }
    

    public disque[] DisquesParGenre(String g) {
        ArrayList<disque> disquesParGenre = new ArrayList<>();
        for (oeuvre o : tabOeuvres) {
            if (o instanceof disque && o.getGenre().equals(g)) {
                disquesParGenre.add((disque) o);
            }
        }
        return disquesParGenre.toArray(new disque[0]);
    }

    public int nombreTotalDesChansons() {
        int count = 0;
        for (oeuvre o : tabOeuvres) {
            if (o instanceof disque) {
                count += ((disque) o).getNombreChansons();
            } else if (o instanceof chanson) {
                count++;
            }
        }
        return count;
    }

    public chanson[] listeChansons() {
        ArrayList<Chanson> toutesLesChansons = new ArrayList<>();
        for (oeuvre o : tabOeuvres) {
            if (o instanceof disque) {
                Chanson[] chansonsDisque = ((disque) o).getTabChansons();
                for (chanson c : chansonsDisque) {
                    toutesLesChansons.add(c);
                }
            } else if (o instanceof chanson) {
                toutesLesChansons.add((chanson) o);
            }
        }
        return toutesLesChansons.toArray(new chanson[0]);
    }
}






