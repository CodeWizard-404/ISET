
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


    $CINrecruteur = $_GET['CINrecruteur'];

    echo "<form method='post'>CINrecruteur:
        <input type='text' name='CINrecruteur' value=".$CINrecruteur." readonly><br>";

    $req = $cnx->query("SELECT * FROM recruteur WHERE CINrecruteur='$CINrecruteur'");
    $donnee = $req->fetch(PDO::FETCH_ASSOC);

    echo "<label>Nom:</label>
        <input type='text' name='nom' value=' ".$donnee['nom']."'> <br>";
    echo "<label>Prenom:</label>
        <input type='text' name='prenom' value=' ".$donnee['prenom']."'> <br>";
    echo "<label>Date de naissance:</label>
        <input type='text' name='dateNaissance' value=' ".$donnee['dateNaissance']."'><br>";
    echo "<label>NumTel:</label>
        <input type='text' name='numTel' value=' ".$donnee['numTel']."'><br>";
    echo "<label>Email:</label>
        <input type='text' name='email' value=' ".$donnee['email']."'><br>";
    echo "<label>Login:</label>
        <input type='text' name='login' value=' ".$donnee['login']."'><br>";
    echo "<label>Mdp:</label>
        <input type='text' name='mdp' value=' ".$donnee['mdp']."'><br>";
    echo "<input type='submit' name='modif'>
        </form>";

    if (isset($_POST['modif'])) {
        $CIN = $_POST['CINrecruteur'];
        $nom = $_POST['nom'];
        $prenom = $_POST['prenom'];
        $dateNaissance = $_POST['dateNaissance'];
        $numTel = $_POST['numTel'];
        $email = $_POST['email'];
        $login = $_POST['login'];
        $mdp = $_POST['mdp'];
        $true = true;

        $res = $cnx->exec("UPDATE recruteur SET nom='$nom',prenom='$prenom',dateNaissance='$dateNaissance',numTel='$numTel',email='$email',login='$login',mdp='$mdp' WHERE CINrecruteur='$CINrecruteur'");

        if ($res !== false) {
            echo "<br>Modification valide";
            header("location: afficherRecru.php");
        } else {
            echo '<br>Modification invalide';
        }
    }
 
?>
<?php
}
?>