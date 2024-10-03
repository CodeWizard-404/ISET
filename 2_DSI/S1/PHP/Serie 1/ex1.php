<?php
$tab = array(
    "php5@gmail.com", 
    "html@yahoo.fr", 
    "machine@hotmail.fr", 
    "webmestre@hotmail.fr", 
    "java@yahoo.fr", 
    "css@yahoo.fr");


$statistics = array();

foreach ($tab as $email) {
    $parts = explode("@", $email);

    if (count($parts) == 2) {
        $provider = $parts[1]; 
        if (array_key_exists($provider, $statistics)) {
            $statistics[$provider]++;
        } else {
            $statistics[$provider] = 1;
        }
    }
}

$totalEmails = count($tab);

foreach ($statistics as $provider => $count) {
    $percentage = ($count / $totalEmails) * 100;
    echo "Fournisseur d'accès : $provider = " . number_format($percentage, 2) . " % <br>";
}
?>
