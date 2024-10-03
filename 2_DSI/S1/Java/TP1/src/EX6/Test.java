package EX6;

import java.util.*;
public class Test {
    public static void main(String[] args){
        Produit p = new Produit();
        Produit q = new Produit();

        p.InitProd("Produit A", 5, 10, 20);
        q.InitProd("Produit B", 3, 15, 15);

        p.ChangerTaux(18.0);

        System.out.println("Produit 1 :");
        p.Affiche();
        System.out.println("Prix TTC du Produit 1 : " + p.CalculPrix());

        System.out.println("\nProduit 2 :");
        q.Affiche();
        System.out.println("Prix TTC du Produit 2 : " + q.CalculPrix());

        Produit[] produits = new Produit[6];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            produits[i] = new Produit();
            System.out.print("\nProduit " + (i + 1));

            System.out.print("\nRéférence : ");
            String r = sc.next();

            System.out.print("Quantité : ");
            int qu = sc.nextInt();

            System.out.print("Prix : ");
            double pr = sc.nextDouble();

            System.out.print("Taux : ");
            double ta = sc.nextDouble();

            produits[i].InitProd(r, qu, pr, ta);
        }
        sc.close();





        
        System.out.println("La liste des produits :");

        double tot = 0;
        for(Produit a: produits){
            a.Affiche();
            tot = a.CalculPrix();
        }
    
        System.out.println("TTC : "+ tot);
        System.out.println("TTc moy :" +tot/6);    

    }
    
}







