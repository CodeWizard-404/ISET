
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
        <input type="text" name="CIN" required> <br>
        Nom:
        <input type="text" name="nom" required> <br>
        Prenom: 
        <input type="text" name="prenom" required> <br>
        Date de naissance: 
        <input type="date" name="dateNaissance" required> <br>
        Personal email: 
        <input type="email" name="email" required> <br>
        Role: 
        <select name="role" required>
            <option value="admin">Admin</option>
            <option value="agent_rh">Agent RH</option>
        </select> <br>
        Login email: 
        <input type="email" name="login" required> <br>
        Password: 
        <input type="text" name="mdp" required> <br>
        <input type="submit" name="ajout">
    </form>
    <?php
        include("../bd/connexion.php");
        if(isset($_POST['ajout'])){
            $CIN=$_POST['CIN'];
            $nom=$_POST['nom'];
            $prenom=$_POST['prenom'];
            $dateNaissance=$_POST['dateNaissance'];
            $email=$_POST['email'];
            $login=$_POST['login'];
            $mdp=$_POST['mdp'];
            $role=$_POST['role'];

            $existsCIN=$cnx->query("SELECT * FROM recruteur WHERE CINrecruteur = '$CIN'");
            $existsLogin=$cnx->query("SELECT * FROM recruteur WHERE login='$login'");
            if ($existsCIN->rowCount() > 0){
                echo "<script>alert('CIN existe déjà');</script>";
            }
            if($existsLogin->rowCount() > 0){
                echo "<script>alert('Le login est déjà utilisé');</script>";
            }
            else{
                $res=$cnx->exec("INSERT INTO recruteur VALUES ('$CIN','$nom','$prenom','$dateNaissance','$email','$login','$mdp',true,'$role')");
                if($res!=0){
                    echo "<br> Ajout avec succès";
                    header("location:afficherRecru.php");
                }
                else{
                    echo "<br> Ajout échoué";
                }
            }
        }
    ?>
</body>
</html>


<?php
}
?>