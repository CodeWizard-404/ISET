<?php
$tabpays1 = array("France", "USA", "Canada", "Italy", "Germany");
echo "Contenu de tabpays1 : <br>";
foreach ($tabpays1 as $p) {
    echo "$p<br>";
}


sort($tabpays1);
echo "<br>Contenu de tabpays1 trié par ordre alphabétique croissant : <br>";
foreach ($tabpays1 as $p) {
    echo $p . "<br>";
}

rsort($tabpays1);
echo "<br>Contenu de tabpays1 trié par ordre alphabétique décroissant : <br>";
foreach ($tabpays1 as $p) {
    echo $p . "<br>";
}



$tabpays2 = array(
    "France" => "Paris",
    "USA" => "Washington",
    "Canada" => "Ottawa",
    "Italy" => "Rome",
    "Germany" => "Berlin"
);

echo "<br><br>Contenu de tabpays2 : <br>";
foreach ($tabpays2 as $p => $c) {
    echo "$p - Capitale: $c <br>";
}

asort($tabpays2);
echo "<br><br>Contenu de tabpays2 trié par ordre alphabétique croissant des pays : <br>";
foreach ($tabpays2 as $p => $c) {
    echo "$p - Capitale: $c <br>";
}

arsort($tabpays2);
echo "<br>Contenu de tabpays2 trié par ordre alphabétique décroissant des pays : <br>";
foreach ($tabpays2 as $p => $c) {
    echo "$p - Capitale: $c <br>";
}


echo "<br><br>Tableau tabpays1 sous forme de tableau HTML : <br>";
echo "<table border='1'>";
foreach ($tabpays1 as $p) {
    echo "<tr><td>$p</td></tr>";
}
echo "</table>";

echo "<br>Tableau tabpays2 sous forme de tableau HTML : <br>";
echo "<table border='1'>";
foreach ($tabpays2 as $p => $c) {
    echo "<tr><td>$p</td><td>$c</td></tr>";
}
echo "</table>";


?>