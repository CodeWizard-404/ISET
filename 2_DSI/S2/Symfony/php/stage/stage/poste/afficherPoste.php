
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table, tr, td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <?php
        include("../bd/connexion.php");
        $poste = $cnx->query("SELECT * from poste WHERE actif = true");
        $posteDesactive = $cnx->query("SELECT * from poste where actif = false");

        echo "<h3>poste existants</h3>
        <table> <tr> 
        <th>Poste</th>
        <th>Description</th>
        <th colspan='2'>Action</th>
        </tr>";
        while ($donnee = $poste->fetch(PDO::FETCH_ASSOC)) {
            echo "<tr>";
            echo "<td>" . $donnee['libelle'] . "</td>";
            echo "<td>" . $donnee['description'] . "</td>";
            echo "<td><a href=supprimerPoste.php?codeP=" . $donnee['codeP'] . ">supprimer</a></td>";
            echo "<td><a href=modifierPoste.php?codeP=" . $donnee['codeP'] . ">modifier</a></td>";
            echo "</tr>";
        }
        echo "</table>";

        echo "<h3>poste supprimé</h3>
        <table> <tr> 
        <th>Poste</th>
        <th>Description</th>
        </tr>";
        while ($donnee = $posteDesactive->fetch(PDO::FETCH_ASSOC)) {
            echo "<tr>";
            echo "<td>" . $donnee['libelle'] . "</td>";
            echo "<td>" . $donnee['description'] . "</td>";
            echo "</tr>";
        }
        echo "</table>";
    ?>
</body>
</html>
