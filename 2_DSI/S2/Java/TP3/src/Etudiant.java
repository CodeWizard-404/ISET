public class Etudiant {
    private String nCE;
    private String nom;
    private float moyenne;
    private ClasseEtudiants classeEtudiant;


    public Etudiant(String nCE) {
        this.nCE = nCE;
    }

    public Etudiant(String nCE, String nom, float moyenne) {
        this.nCE = nCE;
        this.nom = nom;
        this.moyenne = moyenne;
    }

    public String getNCE() {
        return nCE;
    }

    public void setNCE(String nCE) {
        this.nCE = nCE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public ClasseEtudiants getClasseEtudiant() {
        return classeEtudiant;
    }

    public void setClasseEtudiant(ClasseEtudiants classeEtudiant) {
        this.classeEtudiant = classeEtudiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;

        if (o == null || getClass() != o.getClass()) 
            return false;

        Etudiant etudiant = (Etudiant) o;
        return nCE.equals(etudiant.nCE);
    }

    @Override
    public String toString() {
        return "Etudiant : N° CE : " + nCE + ", Nom : " + nom + ", Classe : " + classeEtudiant.getNomClasse() + ", Moyenne : " + moyenne;
    }
}
