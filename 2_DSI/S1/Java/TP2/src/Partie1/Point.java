package Partie1;
public class Point {
    private String nom;
    private int abscisse;
    private int ordonnee;

    public Point(String nom, int abscisse, int ordonnee) {
        this.nom = nom;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public Point(String nom, int abscisse) {
        this(nom, abscisse, 0);
    }

    public Point(String nom) {
        this(nom, 0);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String toString() {
        return nom + " (" + abscisse + ", " + ordonnee + ")";
    }

    public void Affiche() {
        System.out.println(toString());
    }

    public void TranslHoriz(int a) {
        abscisse += a;
    }

    public void TranslVert(int a) {
        ordonnee += a;
    }

    public void Translation(int a, int b) {
        abscisse += a;
        ordonnee += b;
    }

    public void Translation(int a) {
        Translation(a, a);
    }

    public boolean Coincide(Point p) {
        return (abscisse == p.abscisse) && (ordonnee == p.ordonnee);
    }
}

