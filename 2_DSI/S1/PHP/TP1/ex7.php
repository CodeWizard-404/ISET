<?php
echo "Ceci est une ligne créée uniquement en PHP <br>";
echo "<strong>Ceci est la 2ème phrase créée avec PHP <strong><br>";

$url = "www.isetch.rnu.tn";
$texte = "Acces au site de l'ISET CHARGUIA";

?>

<a href="<?php echo $url; ?>">
<?php echo $texte; ?></a>