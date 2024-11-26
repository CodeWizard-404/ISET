package com.example.tp9;

public class Etudiant {
    private String nom;
    private int numero;

    public Etudiant(String nom, int numero) {
        this.nom = nom;
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }
    public int getNumero() {
        return numero;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public String toString() {
        return numero + " - " + nom;
    }

}
