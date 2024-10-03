

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
         table {
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid ;
        }

    </style>
</head>
<body>
    <?php
        include("../bd/connexion.php");
        $candidat=$cnx->query("SELECT * FROM candidat WHERE etat!= 'accepté'");
        echo "<table> <h3>Les candidat</h3><tr> 
        <th>CIN</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>dateNaissance</th>
        <th>numTel</th>
        <th>email</th>        <th>etat</th>

        <th>libellePoste</th>
        <th colspan='2'>Action</th>
        </tr>";
        while ($donnee=$candidat->fetch(PDO::FETCH_ASSOC)){
            echo"<tr>";
            echo"<td>".$donnee['CINcandidat']."</td>";
            echo"<td>".$donnee['nom']."</td>";
            echo"<td>".$donnee['prenom']."</td>";
            echo"<td>".$donnee['dateNaissance']."</td>";
            echo"<td>".$donnee['numTel']."</td>";
            echo"<td>".$donnee['email']."</td>";
            echo"<td>".$donnee['etat']."</td>";
            echo"<td>".$donnee['libellePoste']."</td>";
            echo "<td><a href=modifierCandidat.php?id_candida=" . $donnee['id_candida'] . ">modifier</a></td>";
            echo "<td><a href=../fiche/affichageFiche.php?id_candida=" . $donnee['id_candida'] . ">fiche evaluation</a></td>";
            echo"</tr>";
        }
        echo "</table>";

        $candidat=$cnx->query("SELECT * FROM candidat WHERE etat= 'accepté'");
        echo "<table> <h3>Les employées</h3><tr> 
        <th>CIN</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>dateNaissance</th>
        <th>numTel</th>
        <th>email</th>
        <th>libellePoste</th>
        <th colspan='2'>Action</th>
        </tr>";
        while ($donnee=$candidat->fetch(PDO::FETCH_ASSOC)){
            echo"<tr>";
            echo"<td>".$donnee['CINcandidat']."</td>";
            echo"<td>".$donnee['nom']."</td>";
            echo"<td>".$donnee['prenom']."</td>";
            echo"<td>".$donnee['dateNaissance']."</td>";
            echo"<td>".$donnee['numTel']."</td>";
            echo"<td>".$donnee['email']."</td>";
            echo"<td>".$donnee['libellePoste']."</td>";
            echo "<td><a href=../fiche/affichageFiche.php?id_candida=" . $donnee['id_candida'] . ">fiche evaluation</a></td>";
            echo"</tr>";
        }
        echo "</table>";
    ?>
</body>
</html>
<?php
}
?>