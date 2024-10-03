package vente;

import Produit.Article;
import Produit.ArticleLot;

public class Magasin {
    private Article[] stock;
    private int nbArticles;
    private final int capaciteMax;

    public Magasin(int capaciteMax) {
        this.capaciteMax = capaciteMax;
        this.stock = new Article[capaciteMax];
        this.nbArticles = 0;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public int getNbArticles() {
        return nbArticles;
    }

    public int Ajout(Article article) {
        for (Article a : stock) {
            if (a != null && a.equals(article)) {
                return -1; // Article already exists
            }
        }

        if (nbArticles < capaciteMax) {
            stock[nbArticles++] = article;
            return 0; // Article added successfully
        } else {
            return 1; // Magasin is full
        }
    }

    public void Inventaire() {
        for (Article article : stock) {
            if (article != null) {
                System.out.println(article.toString());
            }
        }
    }

    public int NbreArticlesSimples() {
        int count = 0;
        for (Article article : stock) {
            if (article != null && !(article instanceof ArticleLot)) {
                count++;
            }
        }
        return count;
    }

    public ArticleLot[] ListeArticlesLot() {
        int count = 0;
        for (Article article : stock) {
            if (article instanceof ArticleLot) {
                count++;
            }
        }

        ArticleLot[] articlesLot = new ArticleLot[count];
        count = 0;

        for (Article article : stock) {
            if (article instanceof ArticleLot) {
                articlesLot[count++] = (ArticleLot) article;
            }
        }

        return articlesLot;
    }

    public double TotalTTC() {
        double total = 0.0;
        for (Article article : stock) {
            if (article != null) {
                total += article.PrixTTC();
            }
        }
        return total;
    }

    public Article[] MemeFamille(Article article) {
        int count = 0;
        for (Article a : stock) {
            if (a != null && a.memefamille(article)) {
                count++;
            }
        }

        Article[] sameFamilyArticles = new Article[count];
        count = 0;

        for (Article a : stock) {
            if (a != null && a.memefamille(article)) {
                sameFamilyArticles[count++] = a;
            }
        }

        return sameFamilyArticles;
    }

    public Article getArticle(String code) {
        for (Article article : stock) {
            if (article != null && article.getCode().equals(code)) {
                return article;
            }
        }
        return null;
    }

    public ArticleLot[] NbrePiecesSup(ArticleLot articleLot) {
        int count = 0;
        for (Article article : stock) {
            if (article instanceof ArticleLot) {
                ArticleLot lot = (ArticleLot) article;
                if (lot.getNombrePieces() > articleLot.getNombrePieces()) {
                    count++;
                }
            }
        }

        ArticleLot[] piecesSupArticles = new ArticleLot[count];
        count = 0;

        for (Article article : stock) {
            if (article instanceof ArticleLot) {
                ArticleLot lot = (ArticleLot) article;
                if (lot.getNombrePieces() > articleLot.getNombrePieces()) {
                    piecesSupArticles[count++] = lot;
                }
            }
        }

        return piecesSupArticles;
    }
}
