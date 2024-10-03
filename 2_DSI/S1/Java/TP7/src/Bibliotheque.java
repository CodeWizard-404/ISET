import java.util.*;

public class Bibliotheque {
    private List<Ouvrage> listeOuvrage;
    private List<Abonne> listeAbonne;
    private int nbreOuvrage;
    private int nbreAbonne;

    public Bibliotheque(int tailleOuvrage, int tailleAbonne) {
        listeOuvrage = new ArrayList<>(tailleOuvrage);
        listeAbonne = new ArrayList<>(tailleAbonne);
        nbreOuvrage = 0;
        nbreAbonne = 0;
    }

    public boolean ajoutOuvrage(Ouvrage ouvrage) {
        if (!listeOuvrage.contains(ouvrage)) {
            listeOuvrage.add(ouvrage);
            nbreOuvrage++;
            return true;
        }
        return false;
    }

    public Ouvrage getOuvrage(String titre) {
        for (Ouvrage ouvrage : listeOuvrage) {
            if (ouvrage.getTitre().equals(titre)) {
                return ouvrage;
            }
        }
        return null;
    }

    public boolean ajoutAbonne(Abonne abonne) {
        if (!listeAbonne.contains(abonne)) {
            listeAbonne.add(abonne);
            nbreAbonne++;
            return true;
        }
        return false;
    }

    public Abonne getAbonne(int numId) {
        for (Abonne abonne : listeAbonne) {
            if (abonne.getNumId() == numId) {
                return abonne;
            }
        }
        return null;
    }

    public boolean emprunter(String titre, int numId) {
        Ouvrage ouvrage = getOuvrage(titre);
        Abonne abonne = getAbonne(numId);

        if (ouvrage != null && abonne != null && ouvrage.isExiste() && abonne.getOuvragePris() == null) {
            ouvrage.setExiste(false);
            abonne.setOuvragePris(ouvrage);
            return true;
        }
        return false;
    }

    public void rendre(int numId) {
        Abonne abonne = getAbonne(numId);
        if (abonne != null) {
            Ouvrage ouvrage = abonne.getOuvragePris();
            if (ouvrage != null) {
                ouvrage.setExiste(true);
                abonne.setOuvragePris(null);
            }
        }
    }

    public void info() {
        System.out.println("Ouvrages dans la bibliothèque:");
        for (Ouvrage ouvrage : listeOuvrage) {
            System.out.println(ouvrage);
        }

        System.out.println("\nAbonnés avec des emprunts en cours:");
        for (Abonne abonne : listeAbonne) {
            if (abonne.getOuvragePris() != null) {
                System.out.println(abonne);
            }
        }
    }

    public List<Video> listeVideos() {
        List<Video> videos = new ArrayList<>();
        for (Ouvrage ouvrage : listeOuvrage) {
            if (ouvrage instanceof Video) {
                videos.add((Video) ouvrage);
            }
        }
        return videos;
    }

    public Bibliotheque bibLivre() {
        Bibliotheque bibliothequeLivres = new Bibliotheque(nbreOuvrage, nbreAbonne);
        for (Ouvrage ouvrage : listeOuvrage) {
            if (ouvrage instanceof Livre) {
                bibliothequeLivres.ajoutOuvrage(ouvrage);
            }
        }
        return bibliothequeLivres;
    }
}
