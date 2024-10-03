
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
    <style>
        table, tr, td , th{
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <?php
        include("../bd/connexion.php");
        $competences = $cnx->query("SELECT * FROM competence where active=true");
        while ($competence = $competences->fetch(PDO::FETCH_ASSOC)){
            echo "<table><tr><h3 name='competence'> Competence: " . $competence['libelleCompetence'] . "</h3></th></tr>
            <th>Niveau</th>
            <th>note</th>
            <th>Description</th>
            </tr>";

            $libelleCompetence = $competence['libelleCompetence'];
            echo "<a href='supprimerCompetence.php?libelleCompetence=" . $libelleCompetence . "'>Delete</a>";
            $niveaux = $cnx->query("SELECT * FROM niveau WHERE libelleCompetence = '$libelleCompetence'");
            while ($niveau = $niveaux->fetch(PDO::FETCH_ASSOC)){
                echo "<tr>";
                echo "<td>" . $niveau['niveau'] . "</td>";
                echo "<td>" . $niveau['note'] . "</td>";
                echo "<td>" . $niveau['description'] . "</td>";
                echo "</tr>";
            }
            echo "</table>";

            
        }

        $competences = $cnx->query("SELECT * FROM competence where active=false");
        echo "<h3>competences archivés </h3>";
        while ($competence = $competences->fetch(PDO::FETCH_ASSOC)){
            echo "<table><tr><h3 name='competence'> Competence: " . $competence['libelleCompetence'] . "</h3></th></tr>
            <th>Niveau</th>
            <th>note</th>
            <th>Description</th>
            </tr>";

            $libelleCompetence = $competence['libelleCompetence'];
            echo "<a href='repriseComp.php?libelleCompetence=" . $libelleCompetence . "'>reprise</a>";
            $niveaux = $cnx->query("SELECT * FROM niveau WHERE libelleCompetence = '$libelleCompetence'");
            while ($niveau = $niveaux->fetch(PDO::FETCH_ASSOC)){
                echo "<tr>";
                echo "<td>" . $niveau['niveau'] . "</td>";
                echo "<td>" . $niveau['note'] . "</td>";
                echo "<td>" . $niveau['description'] . "</td>";
                echo "</tr>";
            }
            echo "</table>";

            
        }
    ?>
</body>
</html>
<?php
}
?>