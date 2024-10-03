
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
    include("../bd/connexion.php");
    $libelle=$_GET['libellePoste'];
    $res = $cnx->exec("UPDATE poste SET activé=false WHERE libellePoste='$libelle'");
    if ($res!=0){
        echo "suppression reussite";
        header("location:afficherPoste.php");
        }
    else{
        echo "suppression echoue";
    }
?>
<?php
}
?>

