
<?php
session_start();
if(!isset($_SESSION["user"]))
    {
    	echo '<script>alert("Session expirée")</script>';
    }
else
{
?>

<?php
include("db_config.php");

$CIN = $_GET['candidat'];

$res = $cnx->query("SELECT libellePoste FROM candidat WHERE CINcandidat = '$CIN'");
$donnee = $res->fetch(PDO::FETCH_ASSOC);
$lib = $donnee['libellePoste'];

$resModeles = $cnx->query("SELECT libelléModele FROM modeleevaluation WHERE libelleposte = '$lib'");

if ($resModeles->rowCount() > 0) {
    echo '<select name="modele" id="modele">';
    echo '<option value="">Select a modele:</option>';
    while ($modele = $resModeles->fetch(PDO::FETCH_ASSOC)) {
        echo '<option value="' . $modele['libelléModele'] . '">' . $modele['libelléModele'] . '</option>';
    }
    echo '</select>';
} else {
    echo '<p>No modeles found for this poste</p>';
}
?>
<?php
}
?>