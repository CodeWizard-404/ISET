<?php
session_start();
if (!isset($_SESSION["user"])) {
    echo '<script>alert("Session expirée");</script>';
} else {
    include("../bd/connexion.php");
    if (isset($_GET['libelleCompetence'])) {
        $competence = $_GET['libelleCompetence'];
            $res = $cnx->exec("UPDATE niveau SET active=false WHERE libelleCompetence='$competence'");
            $res = $cnx->exec("UPDATE competence SET active=false WHERE libelleCompetence='$competence'");
            if ($res != 0) {
                echo "Suppression réussie";
                header("location:afficherCompetence.php");
            } else {
                echo "Suppression échouée";
            }
        
    }
}
?>
