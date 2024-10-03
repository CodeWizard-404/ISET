
<?php
include("../bd/connexion.php");

$codeP = $_GET['codeP'];
$req = $cnx->query("SELECT * FROM poste WHERE codeP='$codeP'");
$donnee = $req->fetch(PDO::FETCH_ASSOC);

echo "<form method='POST'>"; 
echo "<label>libelle poste:</label>
    <input type='text' name='libelle' value='" . $donnee['libelle'] . "'> <br>";
echo "<label>description:</label>
    <input type='text' name='description' value='" . $donnee['description'] . "'> <br>";
echo "<input type='submit' name='modif'>
    </form>";

if (isset($_POST['modif'])) {
    $libelle = $_POST['libelle'];
    $description = $_POST['description'];

    $res = $cnx->exec("UPDATE poste SET libelle='$libelle', description='$description' WHERE codeP='$codeP'");

    if ($res !== false) {
        echo "<script>alert('modification valide');</script>";  
        header("location:afficherPoste.php");
    } else {
        echo "<script>alert('modification non valide);</script>";
    }
}
?>
