
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

$candidatId = isset($_GET['candidat']) ? $_GET['candidat'] : null;

if ($candidatId) {
    $sql = "SELECT libellePoste FROM candidat WHERE CINcandidat = '$candidatId'";
    $result = $cnx->query($sql);
    while ($row = $result->fetch(PDO::FETCH_ASSOC)) {
        echo  $row['libellePoste'];
    }
}
?>
<?php
}
?>