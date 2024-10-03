
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


    $id_candida = $_GET['id_candida'];

    echo "<form method='post'>CINcandidat:
        <input type='text' name='CINcandidat' value=".$CINcandidat." readonly><br>";

    $req = $cnx->query("SELECT * FROM candidat WHERE id_candida='$id_candida'");
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
        if ($donnee['etat'] != "accepté") {
            echo "etat: 
        <select name='etat'>
            <option value='en attente'>en attente</option>
            <option value='accepte'>accepté</option>
            <option value='refuse'>refusé</option>
        </select><br>";
        }
        

    echo "<input type='submit' name='modif'>
        </form>";

    if (isset($_POST['modif'])) {
        $CIN = $_POST['CINcandidat'];
        $nom = $_POST['nom'];
        $prenom = $_POST['prenom'];
        $dateNaissance = $_POST['dateNaissance'];
        $numTel = $_POST['numTel'];
        $email = $_POST['email'];
        $etat = $_POST['etat'];

        $res = $cnx->exec("UPDATE candidat SET nom='$nom',prenom='$prenom',dateNaissance='$dateNaissance',numTel='$numTel',email='$email',etat='$etat' WHERE id_candida='$id_candida'");

        if ($res !== false) {
            echo "<br>Modification valide";
            header("location: afficherCandidat.php");
        } else {
            echo '<br>Modification invalide';
        }
    }
 
?>
<?php
}
?>
