
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
            <option value="agentrh">Agent RH</option>
            <option value="superadmin">Super Admin</option>
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
        $CIN = $_POST['CIN'];
        $nom = $_POST['nom'];
        $prenom = $_POST['prenom'];
        $dateNaissance = $_POST['dateNaissance'];
        $email = $_POST['email'];
        $login = $_POST['login'];
        $mdp = $_POST['mdp'];
        $role = $_POST['role'];

        
        switch ($role) {
            case 'admin':
                $tableName = 'admin';
                break;
            case 'agentrh':
                $tableName = 'agentrh';
                break;
            case 'superadmin':
                $tableName = 'superadmin';
                break;
            default:
                $tableName = '';
                break;
        }

        if (!empty($tableName)) {
            $existsLogin = $cnx->query("SELECT * FROM $tableName WHERE login='$login'");
            if ($existsLogin->rowCount() > 0) {
                echo "<script>alert('Le login est déjà utilisé');</script>";
            } else {
                $res = $cnx->exec("INSERT INTO $tableName (CINrecruteur, nom, prenom, dateNaissance, email, login, mdp, activé) VALUES ('$CIN','$nom','$prenom','$dateNaissance','$email','$login','$mdp', true)");
                if ($res != 0) {
                    echo "<br> ajout avec succès";
                    header("location:afficherRecru.php");
                } else {
                    echo "<br> ajout échoué";
                }
            }
        } else {
            echo "Table name not determined correctly.";
        }
    }
?>

</body>
</html>



<?php
}
?>