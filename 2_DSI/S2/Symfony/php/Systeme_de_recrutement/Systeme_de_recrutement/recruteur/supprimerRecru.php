
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
    $sql = $cnx->query("SELECT * FROM recruteur WHERE activé=true ");
    if ($sql->rowCount() > 1) {
        $CINrecruteur=$_GET['CINrecruteur'];
        $res = $cnx->exec("UPDATE recruteur SET activé=false WHERE CINrecruteur='$CINrecruteur'");
        if ($res!=0){
            echo "suppression reussite";
            header("location:afficherRecru.php");
            }
        else{
            echo "suppression echoue";
        }
    }
?>
<?php
}
?>