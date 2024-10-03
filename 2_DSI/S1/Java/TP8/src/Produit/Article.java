package Produit;

public class Article {
    protected String code;
    protected String designation;
    protected double prix;
    protected double tva;
    protected String famille;

    public Article(String code, String designation, double prix, double tva, String famille) {
        this.code = code;
        this.designation = designation;
        this.prix = prix;
        this.tva = tva;
        this.famille = famille;
    }

    public String getCode() {
        return code;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrix() {
        return prix;
    }

    public double getTva() {
        return tva;
    }

    public String getFamille() {
        return famille;
    }

    public String toString() {
        return "Code: " + code + ", Designation: " + designation + ", Prix: " + prix + ", TVA: " + tva + ", Famille: " + famille;
    }

    public boolean memefamille(Article article) {
        return this.famille.equals(article.getFamille());
    }

    public double PrixTTC() {
        return prix * (1 + tva);
    }

    public boolean equals(Article article) {
        return this.code.equals(article.getCode());
    }
}
