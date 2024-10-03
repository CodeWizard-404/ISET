package ex2;

public class Segment {
    private Point extr1;
    private Point extr2;

    public Segment(Point extr1, Point extr2) {
        this.extr1 = extr1;
        this.extr2 = extr2;
    }

    public Segment(int abscisse1, int ordonnee1, int abscisse2, int ordonnee2) {
        this.extr1 = new Point(abscisse1, ordonnee1);
        this.extr2 = new Point(abscisse2, ordonnee2);
    }

    public String toString() {
        return "[" + extr1 + " ; " + extr2 + "]";
    }

    public double Longueur() {
        return extr1.Distance(extr2);
    }

    public boolean Appartient(Point p) {
        double dist1 = extr1.Distance(p);
        double dist2 = extr2.Distance(p);
        return Math.abs(dist1 + dist2 - Longueur()) < 0.001;
    }

    public void translaterSeg(int a, int b) {
        extr1.Deplacer(a, b);
        extr2.Deplacer(a, b);
    }
}


