package Partie2;

import Partie1.Point;

public class TestCarre {
    public static void main(String[] args) {
        Point centre = new Point("C", 3, 3);
        Carre carre1 = new Carre(4, centre);

        System.out.println(carre1.toString());

        carre1.TranslationCarre(2, 2);
        System.out.println("Après TranslationCarre(2,2) : " + carre1.toString());

        Carre carre2 = new Carre(4, 3, 3);
        System.out.println("Les deux carrés sont-ils égaux ? " + carre1.equals(carre2));

        System.out.println("Surface du carré : " + carre1.Surface());
        System.out.println("Périmètre du carré : " + carre1.perimetre());

        System.out.println("Longueur de la diagonale du carré : " + carre1.diagonale());

        Point[] coins = carre1.CoinsDuCarre();
        for (Point p : coins) {
            System.out.println("Coin : " + p.toString());
        }
    }
}

