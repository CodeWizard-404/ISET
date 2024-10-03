
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
$modele = $_GET['modele'];

$resCompetences = $cnx->query("SELECT mc.libellecompetence, mc.niveauMin, c.description
                               FROM modelecompetence mc
                               JOIN competence c ON mc.libellecompetence = c.libelleCompetence
                               WHERE mc.libelléModele = '$modele'");

if ($resCompetences->rowCount() > 0) {
    echo '<p>Competences for selected modele:</p>';
    $i=1;
    while ($competence = $resCompetences->fetch(PDO::FETCH_ASSOC)) {
        echo '<label >' . $competence['libellecompetence'] . '</label>';
        echo '<select name="competence_' . $competence['libellecompetence'] . '">';
        

        $resNiveaux = $cnx->query("SELECT id,niveau FROM niveau WHERE libellecompetence = '{$competence['libellecompetence']}'");
        while ($niveau = $resNiveaux->fetch(PDO::FETCH_ASSOC)) {
            echo '<option value="'. $niveau['niveau'].'">' . $niveau['niveau'] . '</option>';
        }

        
        echo '</select>';
        echo '<p id="' . $competence['libellecompetence'] . '_description">' . $competence['description'] . '</p>';
        $i++;
    }
} else {
    echo '<p>No competences found for this modele</p>';
}
?>
<?php
}
?>