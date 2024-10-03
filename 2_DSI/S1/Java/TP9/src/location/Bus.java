package location;

public class Bus extends Vehicule implements IlocationBus {
    private int nombrePlaces;

    public Bus(String marque, int numId, double chiffreAffairesHT, int nombrePlaces) {
        super(marque, numId, chiffreAffairesHT);
        this.nombrePlaces = nombrePlaces;
    }

    public double ChiffreAffairesTTC() {
        return getChiffreAffairesHT() * 1.2 + nombrePlaces * 1.8;
    }

    public double CoutLocation() {
        return nombrePlaces * 7.5;
    }

    public double AssuranceParLocation() {
        return (nombrePlaces <= 20) ? CoutLocation() * 0.15 : CoutLocation() * 0.20;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }


    public String toString() {
        return "Bus [" +
                " -- marque='" + getMarque() + '\'' +
                " --  Id=" + getId() +
                " --  chiffre Affaires HT=" + getChiffreAffairesHT() +
                " --  nombre Places=" + nombrePlaces +
                ']';
    }

    public void Edition() {
        System.out.println(toString());
    }

}
