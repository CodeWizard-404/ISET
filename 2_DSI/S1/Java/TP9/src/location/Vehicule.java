package location;

public abstract class Vehicule {
    protected String marque;
    protected int id;
    protected double chiffreAffairesHT;

    public Vehicule(String marque, int id, double chiffreAffairesHT) {
        this.marque = marque;
        this.id = id;
        this.chiffreAffairesHT = chiffreAffairesHT;
    }

    public abstract double ChiffreAffairesTTC();

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public double getChiffreAffairesHT() {
        return chiffreAffairesHT;
    }

    public void setChiffreAffairesHT(double chiffreAffairesHT) {
        this.chiffreAffairesHT = chiffreAffairesHT;
    }

    public String toString() {
        return "Vehicule [" +
                " -- marque='" + marque + '\'' +
                " -- id=" + id +
                " -- chiffreAffairesHT=" + chiffreAffairesHT +
                ']';
    }

    public void Edition() {
        System.out.println(toString());
    }
}
