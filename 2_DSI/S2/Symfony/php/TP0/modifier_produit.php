<?php
include("classes.php");

if(isset($_GET['id']) && !empty($_GET['id'])) {
    $id = $_GET['id'];
    
    $produit = Produit::lecture($id);
    if($produit) {
        if(isset($_POST['submit'])) {
            $designation = $_POST['designation'];
            $quantite = $_POST['quantite'];
            $prix = $_POST['prix'];
            $idfam = $_POST['idfam'];
            
            $produit->designation_prod = $designation;
            $produit->quantite_stock = $quantite;
            $produit->prix_unitaire = $prix;
            $produit->idfam = $idfam;
            
            $resultat = $produit->modifier();
            if($resultat === true) {
                echo "Produit modifié avec succès.";
            } else {
                echo $resultat;
            }
        } else {
            ?>
            <form method="post">
                <label for="designation">Désignation:</label><br>
                <input type="text" id="designation" name="designation" value="<?php echo $produit->designation_prod; ?>"><br>
                <label for="quantite">Quantité:</label><br>
                <input type="text" id="quantite" name="quantite" value="<?php echo $produit->quantite_stock; ?>"><br>
                <label for="prix">Prix unitaire:</label><br>
                <input type="text" id="prix" name="prix" value="<?php echo $produit->prix_unitaire; ?>"><br>
                <label for="idfam">ID Famille:</label><br>
                <input type="text" id="idfam" name="idfam" value="<?php echo $produit->idfam; ?>"><br><br>
                <input type="submit" name="submit" value="Modifier">
            </form>
            <?php
        }
    } else {
        echo "Produit non trouvé.";
    }
} else {
    echo "Identifiant du produit non spécifié.";
}
?>