<?php
$emploiDuTemps = array(
    'Lundi' => 'Cours de mathématiques de 9h à 11h',
    'Mardi' => 'Réunion de travail de 14h à 15h',
    'Mercredi' => 'Cours de français de 10h à 12h',
    'Jeudi' => 'Conférence de 16h à 18h',
    'Vendredi' => 'Séance de sport de 17h à 18h',
    'Samedi' => 'Journée libre',
    'Dimanche' => 'Journée libre'
);

$activites = "";

foreach ($emploiDuTemps as $jour => $activite) {
    $activites .= "$jour : $activite\n";
}

echo "<h2>Emploi du temps de la semaine :</h2>";
echo "<pre>$activites</pre>";
?>
