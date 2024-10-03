package EX1;

public class Etudiant implements Comparable<Etudiant> {
    private String nom;
    private String moyenne;
    private String NCE; 
    
    public Etudiant(String nom, String moyenne, String NCE) {
        this.nom = nom;
        this.moyenne = moyenne;
        this.NCE = NCE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getmoyenne() {
        return moyenne;
    }

    public void setmoyenne(String moyenne) {
        this.moyenne = moyenne;
    }

    public String getNCE() {
        return NCE;
    }

    public void setNCE(String NCE) {
        this.NCE = NCE;
    }


    @Override
    public int compareTo(Etudiant e) {
        if (this.NCE == null && e.getNCE() == null) return 0;
        if (this.NCE == null) return -1;
        return this.NCE.compareTo(e.getNCE());
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nCE= " + NCE +
                ", nom= " + nom +
                ", moyenne= " + moyenne +
                '}';
    }
}
