
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

if (isset($_POST['ajout'])) {
    $CINrecruteur = $_POST['recruteur'];
    $CINcandidat = $_POST['candidat'];
    $libelleModele = $_POST['modele'];

    $competenceList = array();
    foreach ($_POST as $key => $value) {
        if (strpos($key, 'competence_') === 0) {
            $competenceName = substr($key, strlen('competence_'));
            $competenceList[$competenceName] = $value;
        }
    }
    $competences = json_encode($competenceList);
    
    $sql = "INSERT INTO ficheevaluation (CINrecruteur, CINcandidat, libelleModele, competenceList) VALUES ('$CINrecruteur', '$CINcandidat', '$libelleModele', '$competences')";
    $cnx->query($sql);
}
?>
<?php
}
?>