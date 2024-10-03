<?php
include("classes.php");

$produits = Produit::lister();

if ($produits) {
    echo "<table border='1'>
            <tr>
                <th>Désignation</th>
                <th>Quantité</th>
                <th>Prix unitaire</th>
                <th>Actions</th>
            </tr>";
    foreach ($produits as $produit) {
        echo "<tr>
                <td>{$produit['designation_prod']}</td>
                <td>{$produit['quantite_stock']}</td>
                <td>{$produit['prix_unitaire']}</td>
                <td>
                    <a href='modifier_produit.php?id={$produit['idprod']}'>Modifier</a>
                    <a href='supprimer_produit.php?id={$produit['idprod']}'>Supprimer</a>
                </td>
            </tr>";
    }
    echo "</table>";
} else {
    echo "Aucun produit trouvé.";
}
?>
