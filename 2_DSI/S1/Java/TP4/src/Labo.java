public class Labo {
    private int num;
    private String specialite;
    private Ordinateur[] listOrdi;
    private int nbrOrdi;

    public Labo(int num, String specialite, int capacite) {
        this.num = num;
        this.specialite = specialite;
        this.listOrdi = new Ordinateur[capacite];
        this.nbrOrdi = 0;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Ordinateur[] getListOrdi() {
        return listOrdi;
    }

    public void setListOrdi(Ordinateur[] listOrdi) {
        this.listOrdi = listOrdi;
    }

    public int getNbrOrdi() {
        return nbrOrdi;
    }

    public void setNbrOrdi(int nbrOrdi) {
        this.nbrOrdi = nbrOrdi;
    }

    public String toString() {
        return "Numero: " + num + "\nSpecialite: " + specialite + "\nListe Ordi: " + nbrOrdi;
    }

    public void Affiche() {
        System.out.println(toString());
    }

    public double coutTotal() {
        double cout = 0;
        for (int i = 0; i < nbrOrdi; i++) {
            cout += listOrdi[i].Cout();
        }
        return cout;
    }

    public void AjoutOrdi(Ordinateur o) {
        if (RechercheIndice(o.getNumSerie()) == -1) {
            if (nbrOrdi < listOrdi.length) {
                listOrdi[nbrOrdi] = o;
                nbrOrdi++;
            } else {
                System.out.println("Impossible d'ajouter un nouvel ordinateur.");
            }
        } else {
            System.out.println("L'ordinateur avec le numéro de série " + o.getNumSerie() + " existe déjà.");
        }
    }

    public void AjoutOrdi(String numSerie, String marque, double prix, double coutInstallation) {
        if (RechercheIndice(numSerie) == -1) {
            if (nbrOrdi < listOrdi.length) {
                listOrdi[nbrOrdi] = new Ordinateur(numSerie, marque, prix, coutInstallation);
                nbrOrdi++;
            } else {
                System.out.println("Impossible d'ajouter un nouvel ordinateur.");
            }
        } else {
            System.out.println("L'ordinateur avec le numéro de série " + numSerie + " existe déjà.");
        }
    }

    private int RechercheIndice(String numSerie) {
        for (int i = 0; i < nbrOrdi; i++) {
            if (listOrdi[i].getNumSerie().equals(numSerie)) {
                return i;
            }
        }
        return -1;
    }

    public Ordinateur RechercheOrdi(String numSerie) {
        int index = RechercheIndice(numSerie);
        if (index != -1) {
            return listOrdi[index];
        }
        return null; 
    }

    public void SuppOrdi(int indice) {
        if (indice >= 0 && indice < nbrOrdi) {
            for (int i = indice; i < nbrOrdi - 1; i++) {
                listOrdi[i] = listOrdi[i + 1];
            }
            listOrdi[nbrOrdi - 1] = null;
            nbrOrdi--;
        } else {
            System.out.println("Impossible de supprimer l'ordinateur.");
        }
    }

    public void SuppOrdi(String numSerie) {
        int index = RechercheIndice(numSerie);
        if (index != -1) {
            SuppOrdi(index);
        } else {
            System.out.println("L'ordinateur avec le numéro de série " + numSerie + " n'existe pas.");
        }
    }

    public Ordinateur[] ListeMarque(String marque) {
        Ordinateur[] OrdiM = new Ordinateur[nbrOrdi];
        int count = 0;
        for (int i = 0; i < nbrOrdi; i++) {
            if (listOrdi[i].getMarque().equals(marque)) {
                OrdiM[count] = listOrdi[i];
                count++;
            }
        }
        Ordinateur[] result = new Ordinateur[count];
        System.arraycopy(OrdiM, 0, result, 0, count);
        return result;
    }

    public void viderLabo() {
        listOrdi = new Ordinateur[listOrdi.length];
        nbrOrdi = 0;
    }
}
