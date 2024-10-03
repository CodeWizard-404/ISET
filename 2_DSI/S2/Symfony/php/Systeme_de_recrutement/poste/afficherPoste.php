
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
    <style>
        table, tr, td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <?php
        include("../bd/connexion.php");
        $poste = $cnx->query("SELECT p.*, r.nom AS recruter FROM poste p INNER JOIN recruteur r ON p.CINrecruteur = r.CINrecruteur WHERE p.activé = true");
        $posteDesactive = $cnx->query("SELECT p.*, r.nom AS recruter FROM poste p INNER JOIN recruteur r ON p.CINrecruteur = r.CINrecruteur WHERE p.activé = false");

        echo "<h3>poste existants</h3>
        <table> <tr> 
        <th>Poste</th>
        <th>Description</th>
        <th>Cree par</th>
        <th colspan='2'>Action</th>
        </tr>";
        while ($donnee = $poste->fetch(PDO::FETCH_ASSOC)) {
            echo "<tr>";
            echo "<td>" . $donnee['libellePoste'] . "</td>";
            echo "<td>" . $donnee['description'] . "</td>";
            echo "<td>" . $donnee['recruter'] . "</td>";
            echo "<td><a href=supprimerPoste.php?libellePoste=" . $donnee['libellePoste'] . ">supprimer</a></td>";
            echo "<td><a href=modifierPoste.php?libellePoste=" . $donnee['libellePoste'] . ">modifier</a></td>";
            echo "</tr>";
        }
        echo "</table>";

        echo "<h3>poste supprimé</h3>
        <table> <tr> 
        <th>Poste</th>
        <th>Description</th>
        <th>Cree par</th>
        </tr>";
        while ($donnee = $posteDesactive->fetch(PDO::FETCH_ASSOC)) {
            echo "<tr>";
            echo "<td>" . $donnee['libellePoste'] . "</td>";
            echo "<td>" . $donnee['description'] . "</td>";
            echo "<td>" . $donnee['recruter'] . "</td>";
            echo "</tr>";
        }
        echo "</table>";
    ?>
</body>
</html>
<?php
}
?>