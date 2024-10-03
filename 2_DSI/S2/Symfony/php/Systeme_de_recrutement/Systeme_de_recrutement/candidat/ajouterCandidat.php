
<?php
session_start();
if(!isset($_SESSION["user"]))
    {
    	echo '<script>alert("Session expirée")</script>';
    }
else
{
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="post">
        <label for="nce">CIN:</label>
        <input type="text" name="CIN"> <br>
        Nom:
        <input type="text" name="nom"> <br>
        Prenom: 
        <input type="text" name="prenom"> <br>
        date de naissance: 
        <input type="date" name="dateNaissance"> <br>
        num tel: 
        <input type="text" name="numTel"> <br>
        personal email: 
        <input type="email" name="email"> <br>
        poste: 
        <select name="postecandidat">
            <?php
                include("../bd/connexion.php");
                $res=$cnx->query("SELECT * FROM poste WHERE activé=true");
                while($donnee= $res->fetch(PDO::FETCH_ASSOC)){
                    echo "<option value=".$donnee['libellePoste'].">".$donnee['libellePoste']."</option>";
                }
            ?>
        </select> 
        <br>
        etat: 
        <select name="etat">
            <option value="en attente">en attente</option>
            <option value="accepté">accepté</option>
            <option value="accepté">refusé</option>
        </select>
        <br>
        <input type="submit" name="ajout">
    </form>
    <?php
        include("../bd/connexion.php");
        if(isset($_POST['ajout'])){
            $CIN=$_POST['CIN'];
            $nom=$_POST['nom'];
            $prenom=$_POST['prenom'];
            $dateNaissance=$_POST['dateNaissance'];
            $numTel=$_POST['numTel'];
            $email=$_POST['email'];
            $postecandidat=$_POST['postecandidat'];
            $etat=$_POST['etat'];
            $res=$cnx->exec("INSERT INTO candidat VALUES ('$CIN','$nom','$prenom','$dateNaissance','$numTel','$email','$postecandidat','$etat')");
            if($res!=0){
                echo "<br> ajout avec succes";
                header("location:afficherCandidat.php");

            }
            else{
                echo "<br> ajout echoué";
            }
        }
    ?>
</body>
</html>
<?php
}
?>