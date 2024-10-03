<?php
include("classes.php");

if(isset($_GET['id']) && !empty($_GET['id'])) {
    $id = $_GET['id'];
    $produit = Produit::lecture($id);
    if($produit) {
        $resultat = $produit->supprimer();
        if($resultat === true) {
            echo "Produit supprimé avec succès.";
        } else {
            echo $resultat;
        }
    } else {
        echo "Produit non trouvé.";
    }
} else {
    echo "Identifiant du produit non spécifié.";
}
?>
