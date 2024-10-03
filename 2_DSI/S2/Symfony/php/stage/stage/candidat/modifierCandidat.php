<?php
include("../bd/connexion.php");


    $id_candida = $_GET['id_candida'];
    $req = $cnx->query("SELECT * FROM candidature WHERE id_candida='$id_candida'");
    $donnee = $req->fetch(PDO::FETCH_ASSOC);
    echo "<form method='post'>CIN:
        <input type='text' name='CIN_candida' value=".$donnee['CIN_candida']." readonly><br>";
    echo "<label>Nom:</label>
        <input type='text' name='nom' value=' ".$donnee['nom']."'> <br>";
    echo "<label>Prenom:</label>
        <input type='text' name='prenom' value=' ".$donnee['prenom']."'> <br>";
    echo "<label>Email:</label>
        <input type='text' name='email' value=' ".$donnee['email']."'><br>";
        if ($donnee['etat'] != "accepté") {
            echo "etat: 
            <select name='etat'>
                <option value='enAttente'>en attente</option>
                <option value='accepte'>accepté</option>
                <option value='refuse'>refusé</option>
            </select><br>";
        }
        

    echo "<input type='submit' name='modif'>
        </form>";

    if (isset($_POST['modif'])) {
        $CIN_candida = $_POST['CIN_candida'];
        $nom = $_POST['nom'];
        $prenom = $_POST['prenom'];
        $email = $_POST['email'];
        $etat = $_POST['etat'];

        $res = $cnx->exec("UPDATE candidature SET nom='$nom',prenom='$prenom',email='$email',etat='$etat' WHERE id_candida='$id_candida'");

        if ($res !== false) {
            echo "<br>Modification valide";
            header("location: afficherCandidat.php");
        } else {
            echo '<br>Modification invalide';
        }
    }
 
?>
