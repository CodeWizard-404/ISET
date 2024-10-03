
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
        table, tr, td , th{
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <?php
        include("../bd/connexion.php");
        $recruteurs=$cnx->query("SELECT * FROM recruteur WHERE activé = true");
        $exRecruteurs=$cnx->query("SELECT * FROM recruteur WHERE activé = false");
        echo "<table> <h3>Les recruteurs</h3><tr> 
        <th>NCE</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>dateNaissance</th>
        <th>numTel</th>
        <th>email</th>
        <th>login</th>
        <th>mdp</th>
        <th>role</th>
        <th colspan='2'>Action</th>
        </tr>";
        while ($donnee=$recruteurs->fetch(PDO::FETCH_ASSOC)){
            echo"<tr>";
            echo"<td>".$donnee['CINrecruteur']."</td>";
            echo"<td>".$donnee['nom']."</td>";
            echo"<td>".$donnee['prenom']."</td>";
            echo"<td>".$donnee['dateNaissance']."</td>";
            echo"<td>".$donnee['numTel']."</td>";
            echo"<td>".$donnee['email']."</td>";
            echo"<td>".$donnee['role']."</td>";
            echo"<td>".$donnee['login']."</td>";
            echo"<td>".$donnee['mdp']."</td>";
            echo "<td><a href=supprimerRecru.php?CINrecruteur=" . $donnee['CINrecruteur'] . ">supprimer</a></td>";
            echo "<td><a href=modifierRecru.php?CINrecruteur=" . $donnee['CINrecruteur'] . ">modifier</a></td>";
            echo"</tr>";
        }
        echo "</table>";


        echo "<table> <h3>ex recruteurs</h3><tr> 
        <th>NCE</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>dateNaissance</th>
        <th>numTel</th>
        <th>email</th>
        <th>role</th>
        <th>login</th>
        <th>mdp</th>
        </tr>";
        while ($donnee=$exRecruteurs->fetch(PDO::FETCH_ASSOC)){
            echo"<tr>";
            echo"<td>".$donnee['CINrecruteur']."</td>";
            echo"<td>".$donnee['nom']."</td>";
            echo"<td>".$donnee['prenom']."</td>";
            echo"<td>".$donnee['dateNaissance']."</td>";
            echo"<td>".$donnee['numTel']."</td>";
            echo"<td>".$donnee['email']."</td>";
            echo"<td>".$donnee['role']."</td>";
            echo"<td>".$donnee['login']."</td>";
            echo"<td>".$donnee['mdp']."</td>";
            echo"</tr>";
        }
        echo "</table>"

    ?>
</body>
</html>
<?php
}
?>