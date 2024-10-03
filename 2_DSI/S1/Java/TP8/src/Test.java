import Produit.Article;
import Produit.ArticleLot;
import vente.Magasin;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Capacité maximale du magasin : ");
        int capaciteMax = scanner.nextInt();

        Magasin magasin = new Magasin(capaciteMax);

        int choix;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un article");
            System.out.println("2. Afficher l'inventaire");
            System.out.println("3. Nombre d'articles simples");
            System.out.println("4. Liste d'articles Lot");
            System.out.println("5. Total TTC");
            System.out.println("6. Articles de la même famille");
            System.out.println("7. Rechercher un article par code");
            System.out.println("8. Articles avec nombre de pièces supérieur");
            System.out.println("0. Quitter");

            System.out.print("\nChoix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("\nCode de l'article : ");
                    String code = scanner.next();
                    System.out.print("Désignation : ");
                    String designation = scanner.next();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    System.out.print("TVA : ");
                    double tva = scanner.nextDouble();
                    System.out.print("Famille : ");
                    String famille = scanner.next();

                    System.out.print("L'article est un lot ? (1 pour Oui, 0 pour Non) : ");
                    int isLot = scanner.nextInt();

                    if (isLot == 1) {
                        System.out.print("Nombre de pièces dans le lot : ");
                        int nombrePieces = scanner.nextInt();
                        System.out.print("Remise : ");
                        double remise = scanner.nextDouble();

                        ArticleLot articleLot = new ArticleLot(code, designation, prix, tva, famille, nombrePieces, remise);
                        magasin.Ajout(articleLot);
                    } else {
                        Article article = new Article(code, designation, prix, tva, famille);
                        magasin.Ajout(article);
                    }
                    break;

                case 2:
                    magasin.Inventaire();
                    break;

                case 3:
                    System.out.println("Nombre d'articles simples : " + magasin.NbreArticlesSimples());
                    break;

                case 4:
                    ArticleLot[] articlesLot = magasin.ListeArticlesLot();
                    System.out.println("\nListe d'articles Lot : ");
                    for (ArticleLot articleLot : articlesLot) {
                        System.out.println(articleLot.toString());
                    }
                    break;

                case 5:
                    System.out.println("Total TTC : " + magasin.TotalTTC());
                    break;

                case 6:
                    System.out.print("Code de l'article : ");
                    String familleCode = scanner.next();
                    Article familleArticle = magasin.getArticle(familleCode);
                    if (familleArticle != null) {
                        Article[] sameFamilyArticles = magasin.MemeFamille(familleArticle);
                        System.out.println("\nArticles de la même famille : ");
                        for (Article a : sameFamilyArticles) {
                            System.out.println(a.toString());
                        }
                    } else {
                        System.out.println("Article non trouvé.");
                    }
                    break;

                case 7:
                    System.out.print("Code de l'article : ");
                    String rechercheCode = scanner.next();
                    Article rechercheArticle = magasin.getArticle(rechercheCode);
                    if (rechercheArticle != null) {
                        System.out.println("Article trouvé : " + rechercheArticle.toString());
                    } else {
                        System.out.println("Article non trouvé.");
                    }
                    break;

                case 8:
                    System.out.print("Nombre de pièces minimum : ");
                    int piecesMin = scanner.nextInt();
                    ArticleLot articleLot = new ArticleLot("", "", 0, 0, "", piecesMin, 0);
                    ArticleLot[] piecesSupArticles = magasin.NbrePiecesSup(articleLot);
                    System.out.println("\nArticles avec nombre de pièces supérieur à " + piecesMin + " : ");
                    for (ArticleLot a : piecesSupArticles) {
                        System.out.println(a.toString());
                    }
                    break;
            }

        } 
        while (choix != 0);
        scanner.close();
    }
    
}
