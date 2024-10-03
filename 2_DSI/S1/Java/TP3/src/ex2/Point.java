package ex2;

public class Point {
    private int abscisse;
    private int ordonnee;

    public Point(int abscisse, int ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }
    public String toString(){
        return "("+abscisse+","+ordonnee+")";
    }
    public void SymHoriz() {
        ordonnee = -ordonnee;
    }

    public void SymVert() {
        abscisse = -abscisse;
    }

    public void Deplacer(int a,int b){
        abscisse += a;
        ordonnee += b;
    }
    public void Deplacer(int a){
        Deplacer(a,a);
    }

    public int getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }
    public boolean equals(Point p) {
        return abscisse == p.getAbscisse() && ordonnee == p.getOrdonnee();
    }
    public double Distance(Point p) {
        int dx = abscisse - p.getAbscisse();
        int dy = ordonnee - p.getOrdonnee();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
