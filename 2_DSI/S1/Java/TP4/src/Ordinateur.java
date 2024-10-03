public class Ordinateur {
    private String numSerie ;
    private String marque;
    private double prix;
    private double countInstallation;
    
    public Ordinateur(String numSerie, String marque, double prix,double countInstallation) {
        this.numSerie = numSerie;
        this.marque = marque;
        this.prix = prix;
        this.countInstallation = countInstallation;
    }
    public String getNumSerie() {
        return numSerie;
    }
    public void setNumSerie(String numSerie) {}
    public String getMarque(){
        return marque;
    }
    public void setMarque(String marque) {}
    public double getPrix(){
        return prix;
    }
    public void setPrix(double prix){}
    public double getCountInstallation(){
        return countInstallation;
    }
    public void setCountInstallation(){}

    public double Cout(){
        return prix + countInstallation;
    }
    public String toString(){
        return "Numero de Serie: "+numSerie+"\nMarque: "+marque+"\nPrix: "+prix+"\nCout"+countInstallation;
    }
    public void Affiche(){
        System.out.println(toString());
    }
    public boolean equals(Ordinateur other){
        if (other == null){
            return false;
        }
        return (other.numSerie == this.numSerie);

    }
}
