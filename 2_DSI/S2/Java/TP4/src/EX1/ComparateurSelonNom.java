package EX1;

import java.util.Comparator;

public class ComparateurSelonNom implements Comparator<Etudiant> {
    public int compare(Etudiant e1, Etudiant e2) {
        if (e1.getNom() == null && e2.getNom() == null)
            return 0;
        if (e1.getNom() == null)
            return -1;
        return e1.getNom().compareTo(e2.getNom());
    }
}