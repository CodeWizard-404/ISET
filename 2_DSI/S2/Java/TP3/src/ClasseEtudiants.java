import java.util.ArrayList;

public class ClasseEtudiants {
    private String nomClasse;
    private ArrayList<Etudiant> listeEtudiants;

    public ClasseEtudiants(String nomClasse) {
        this.nomClasse = nomClasse;
        this.listeEtudiants = new ArrayList<>();
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public boolean ajouterEtudiant(Etudiant etudiant) {
        if (etudiant != null) {
            etudiant.setClasseEtudiant(this);
            return listeEtudiants.add(etudiant);
        }
        return false;
    }

    public int ajouterEtudiant(int index, Etudiant etudiant) {
        if (index < 0 || index > listeEtudiants.size() - 1) {
            return -1;
        }

        if (listeEtudiants.contains(etudiant)) {
            return 0;
        }

        etudiant.setClasseEtudiant(this);
        listeEtudiants.add(index, etudiant);
        return 1;
    }

    public boolean ajouterAuDebut(Etudiant etudiant) {
        if (listeEtudiants.contains(etudiant)) {
            return false;
        }

        etudiant.setClasseEtudiant(this);
        listeEtudiants.add(0, etudiant);
        return true;
    }

    public Etudiant chercherEtudiant(String nCE) {
        for (Etudiant e : listeEtudiants) {
            if (e.getNCE().equals(nCE)) {
                return e;
            }
        }
        return null;
    }

    public Etudiant chercherEtudiant(int index) {
        if (index >= 0 && index < listeEtudiants.size()) {
            return listeEtudiants.get(index);
        }
        return null;
    }

    public boolean SupprimerEtudiant(String nCE) {
        Etudiant etudiant = chercherEtudiant(nCE);
        if (etudiant != null) {
            listeEtudiants.remove(etudiant);
            return true;
        }
        return false;
    }

    public void afficherListeEtudiant(){
        System.out.println("La liste des étudiants de la classe est:");
        for (Etudiant e : this.listeEtudiants){
            System.out.println(e.toString());
        }
    }

    public void viderEtudiants() {
        listeEtudiants.clear();
    }


}
