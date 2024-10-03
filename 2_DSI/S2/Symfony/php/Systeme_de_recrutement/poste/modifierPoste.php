
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

$libellePoste = $_GET['libellePoste'];
$req = $cnx->query("SELECT * FROM poste WHERE libellePoste='$libellePoste'");
$donnee = $req->fetch(PDO::FETCH_ASSOC);

echo "<form method='POST'>"; 
echo "<label>libelle poste:</label>
    <input type='text' name='libellePoste' value='" . $donnee['libellePoste'] . "'> <br>";
echo "<label>description:</label>
    <input type='text' name='description' value='" . $donnee['description'] . "'> <br>";
echo "<input type='submit' name='modif'>
    </form>";

if (isset($_POST['modif'])) {
    $libellePoste = $_POST['libellePoste'];
    $description = $_POST['description'];

    $res = $cnx->exec("UPDATE poste SET libellePoste='$libellePoste', description='$description' WHERE libellePoste='$libellePoste'");

    if ($res !== false) {
        echo "<script>alert('modification valide');</script>";  
        header("location:afficherPoste.php");
    } else {
        echo "<script>alert('modification non valide);</script>";
    }
}
?>
<?php
}
?>