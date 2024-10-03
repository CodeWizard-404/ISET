<?php
echo "<h1>Calcul sur les variables</h1>";

$TVA = 0.206;
$prix = 150;
$Nombre = 10;

$prixHT = $prix * $Nombre;

$prixTTC = $prixHT + ($prixHT * $TVA);

echo "Prix HT pour 10 articles : " . $prixHT . "$<br>";
echo "Prix TTC pour 10 articles : " . $prixTTC . "$";
?>