package EX2;


class Abonne {
    private String numTel;
    private String nom;
    private String adresse;

    public Abonne(String numTel, String nom, String adresse) {
        this.numTel = numTel;
        this.nom = nom;
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "N° Tel : " + numTel + ", Nom : " + nom + ", Adresse : " + adresse;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Abonne abonne = (Abonne) obj;
        return numTel.equals(abonne.numTel);
    }

    @Override
    public int hashCode() {
        return numTel.hashCode();
    }
}
