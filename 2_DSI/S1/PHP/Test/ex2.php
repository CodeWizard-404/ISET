<?php
$tabdisciplines = array(
    "TI" => array("DSI", "RSI", "SEM"),
    "AA" => array("LTI", "MA")
);

ksort($tabdisciplines);

echo '<table border="1">';
echo '<tr><th>Departements</th><th>Disciplines</th></tr>';

foreach ($tabdisciplines as $departement => $disciplines) {
    $rowspan = count($disciplines);
    echo '<tr>';
    echo '<td rowspan="' . $rowspan . '">' . $departement . '</td>';
    
    echo '<td>' . array_shift($disciplines) . '</td>';
    echo '</tr>';
    
    foreach ($disciplines as $discipline) {
        echo '<tr><td>' . $discipline . '</td></tr>';
    }
}

echo '</table>';
?>
