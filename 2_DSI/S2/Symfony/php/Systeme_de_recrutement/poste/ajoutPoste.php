
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
        libelle du poste: 
        <input type="text" name="libelle" required> <br>
        description:
        <input type="text" name="description" required> <br>
        Cree par: 
        <select name="recruteur" required>
            <?php
                include("../bd/connexion.php");
                $res = $cnx->query("SELECT * FROM recruteur WHERE activé=true");
                while ($donnee = $res->fetch(PDO::FETCH_ASSOC)) {
                    echo "<option value=" . $donnee['CINrecruteur'] . ">" . $donnee['nom'] . "</option>";
                }
            ?>
        </select>
        <br>
        <input type="submit" name="ajout">
    </form>
    
    <?php
        include("../bd/connexion.php");
        if (isset($_POST["ajout"])) {
            $libelle = $_POST['libelle'];
            $description = $_POST['description'];
            $recruteur = $_POST['recruteur'];
            
            try {
                $existe = $cnx->query("SELECT * FROM poste WHERE libellePoste='$libelle'");
                if ($existe->rowCount() > 0) {
                    echo "<script>alert('le poste existe déjà');</script>";
                } else {
                    $res = $cnx->exec("INSERT INTO poste VALUES ('$libelle','$description','$recruteur', true)");
                    if ($res !== false) {
                        header("location:afficherPoste.php");
                    } else {
                        echo "<script>alert('Ajout échoué');</script>";
                    }
                }
            } catch (PDOException $e) {
                echo "<script>alert('Erreur lors de l'ajout');</script>";
            }
        }
    ?>
</body>
</html>
<?php
}
?>