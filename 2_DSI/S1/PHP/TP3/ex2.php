<?php
$tabnotes1=array(15, 18, 12, 14, 17);
$tabcof=array(2, 3, 1, 2, 2);

$snotes =0;
$scof =0;
for ($i=0;$i<5;$i++){
    $notcof=$tabnotes1[$i]*$tabcof[$i];
    $snotes += $notcof;
    $scof+= $tabcof[$i];
    echo "Note Matiere ".($i+1).": ".$tabnotes1[$i]."<br>";
}
$moy=$snotes/$scof;
echo "Moyenne : ".$moy . "<br><br>";

rsort($tabnotes1);
foreach($tabnotes1 as $x=>$y){
    echo "Note Matiere ".($x+1)." : ".$y."<br>";
}

$tabmatieres = array("UML", "IOT", "CSS", "PHP", "SQL");
$tabnotes2 = array();

for ($i = 0; $i < 5; $i++) {
    $tabnotes2[$tabmatieres[$i]] = $tabnotes1[$i];
}

echo "<br><br>";
$keys = array_keys($tabnotes2);
$values = array_values($tabnotes2);
$i = 0;

while ($i < 5) {
    $matiere = $keys[$i];
    $note = $values[$i];
    echo $matiere . " : " . $note . "<br>";
    $i++;
}

?>