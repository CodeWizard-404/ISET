package Partie2;

import Partie1.Point;

public class Carre {
    private int cote;
    private Point centre;

    public Carre(int cote, Point centre) {
        this.cote = cote;
        this.centre = centre;
    
    }
    public Carre(int cote, int x, int y) {
        this.cote = cote;
        this.centre = new Point("Centre", x, y);
    }
    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public String toString() {
        return "Carré de côté " + cote + " avec centre " + centre.toString();
    }

    public void TranslCarreHoriz(int a) {
        centre.TranslHoriz(a);
    }

    public void TranslCarreVert(int a) {
        centre.TranslVert(a);
    }

    public void TranslationCarre(int a, int b) {
        centre.Translation(a, b);
    }
    public void TranslationCarre(int a) {
        TranslationCarre(a, a);
    }

    public boolean equals(Carre C) {
        return (cote == C.cote && centre.Coincide(C.centre));
    }

    public int Surface() {
        return cote * cote;
    }

    public int perimetre() {
        return 4 * cote;
    }

    public double diagonale() {
        return Math.sqrt(2) * cote;
    }
    public Point[] CoinsDuCarre() {
        Point[] coins = new Point[4];
        int x = centre.getAbscisse();
        int y = centre.getOrdonnee();

        int halfCote = cote / 2;
        coins[0] = new Point("Haut gauche", x - halfCote, y - halfCote);
        coins[1] = new Point("Haut droit", x + halfCote, y - halfCote);
        coins[2] = new Point("Bas gauche", x - halfCote, y + halfCote);
        coins[3] = new Point("Bas droit", x + halfCote, y + halfCote);

        return coins;
    }
}
