
package ex2;

public class Cercle {
    private int rayon;
    private Point centre;

    public Cercle(int abscisse, int ordonnee, int rayon) {
        this.centre = new Point(abscisse, ordonnee);
        this.rayon = rayon;
    }

    public Cercle(Point centre, int rayon) {
        this.centre = centre;
        this.rayon = rayon;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void SymCercleHoriz() {
        centre.SymHoriz();
    }

    public void SymCercleVert() {
        centre.SymVert();
    }

    public void Translater(int a, int b) {
        centre.Deplacer(a, b);
    }

    public void Translater(int a) {
        centre.Deplacer(a);
    }

    public boolean equals(Cercle c) {
        return centre.equals(c.getCentre()) && rayon == c.getRayon();
    }

    public double Surface() {
        return Math.PI * rayon * rayon;
    }

    public String toString() {
        return "Centre: " + centre + ", Rayon = " + rayon;
    }
}
