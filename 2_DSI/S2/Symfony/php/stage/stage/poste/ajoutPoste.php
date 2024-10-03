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
        <input type="submit" name="ajout">
    </form>
    
    <?php
        include("../bd/connexion.php");
        if (isset($_POST["ajout"])) {
            $libelle = $_POST['libelle'];
            $description = $_POST['description'];
            // try {
                    $res = $cnx->exec("INSERT INTO poste(libelle,description,actif) VALUES ('$libelle','$description', true)");
                    if ($res!=false) {
                        header("location:afficherPoste.php");
                    } else {
                        echo "<script>alert('Ajout échoué');</script>";
                    }
            // } catch (PDOException $e) {
            //     echo "<script>alert('Erreur lors de l ajout')</script>, $e";
            // }
        }
    ?>
</body>
</html>