
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
    $modele = $_POST['modele'];  
    $sql = $cnx->query("SELECT * FROM ficheevaluation WHERE libelleModele= '$modele' ");
    if ($sql->rowCount()<1) {
        $res = $cnx->exec("DELETE FROM modeleevaluation  WHERE libelléModele= '$modele'");
        if ($res!=0){
            echo "suppression reussite";
        }
        else{
            echo "suppression echoue";
        }
    } else {
        echo "<script>alert('Il y a eu une évaluation avec ce modèle, vous ne pouvez pas le supprimer');</script>";
    }
?>
<?php
}
?>