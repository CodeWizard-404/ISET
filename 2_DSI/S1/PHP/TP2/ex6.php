<?php
$pair = null; 

while ($pair === null) {
    $nb = rand(1, 100);

    if ($nb % 2 === 0) {
        $pair = $nb;
    }
}

echo "Le premier entier pair obtenu est : $pair";
?>
