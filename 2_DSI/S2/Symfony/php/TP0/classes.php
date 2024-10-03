<?php
include("connexion.php");

//Définition de la classe Produit
class Produit
{   
    public $idprod;
    public $designation_prod;
    public $quantite_stock;
    public $prix_unitaire;
    public $idfam;

    function __construct($id, $des, $q, $p, $idf){
        $this->idprod = $id; 
        $this->designation_prod = $des; 
        $this->quantite_stock = $q;
        $this->prix_unitaire = $p;
        $this->idfam = $idf;
    }

    function ajouter() {
        $cnx = Connexion::getInstance()->getConnexion();
        if ($cnx) {
            $sql = "INSERT INTO produit (designation_prod, quantite_stock, prix_unitaire, idfam) 
                    VALUES ('$this->designation_prod', '$this->quantite_stock', '$this->prix_unitaire', '$this->idfam')";
            $nblignes = $cnx->exec($sql);

            if ($nblignes != 1) {   
                return "Insertion impossible";
            } else {
                $cnx = null;
                return true;
            }
        } else {
            return "Connexion impossible";
        }
    }

    function supprimer() {
        $cnx = Connexion::getInstance()->getConnexion(); 
        if ($cnx) {
            $sql = "DELETE FROM produit WHERE idprod=$this->idprod";
            $nblignes = $cnx->exec($sql);
            if ($nblignes != 1) {    
                return "Suppression impossible";
            } else {
                $cnx = null;
                return true; 
            }
        } else {
            return "Connexion impossible";
        }
    }

    function modifier() {
        $cnx = Connexion::getInstance()->getConnexion(); 
        if ($cnx) {
            $sql = "UPDATE produit SET 
                    designation_prod='$this->designation_prod',
                    quantite_stock ='$this->quantite_stock',
                    prix_unitaire='$this->prix_unitaire',
                    idfam ='$this->idfam'
                    WHERE idprod=$this->idprod";
            $nblignes = $cnx->exec($sql);
            if ($nblignes != 1) {
                return "Modification impossible";
            } else {
                $cnx = null;
                return true;
            }
        } else {
            return "Connexion impossible";
        }
    }

    static function lecture($id) {
        $res = null;
        $cnx = Connexion::getInstance()->getConnexion();
        if ($cnx) {
            $sql = "SELECT * FROM produit WHERE idprod=$id";
            $resultat = $cnx->query($sql);
            if ($resultat && $resultat->rowCount() == 1) {
                $prod = $resultat->fetch(PDO::FETCH_ASSOC);
                $res = new Produit($prod["idprod"], $prod["designation_prod"], $prod["quantite_stock"], $prod["prix_unitaire"], $prod["idfam"]);
                $resultat->closeCursor();
                $cnx = null;
            }
        }
        return $res;
    }

    static function lister() {
        $tab = null;
        $cnx = Connexion::getInstance()->getConnexion();
        if ($cnx) {
            $sql = "SELECT * FROM produit ORDER BY designation_prod";
            $resultat = $cnx->query($sql);
            if ($resultat) {
                $tab = $resultat->fetchAll(PDO::FETCH_ASSOC);
                $cnx = null;
                return $tab;
            }
        }
        return $tab;
    }
}
?>
