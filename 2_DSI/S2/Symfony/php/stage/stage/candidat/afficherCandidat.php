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
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <?php
        include("../bd/connexion.php");

        $candidatEnAttente = $cnx->query("SELECT candidature.*, poste.libelle AS libelle_poste 
                                                FROM candidature 
                                                INNER JOIN poste 
                                                ON candidature.codeP = poste.codeP 
                                                WHERE candidature.etat = 'enAttente'");

        echo "<h3>Candidats en attente:</h3>";
        affichage($candidatEnAttente);

        $candidatAccepte = $cnx->query("SELECT candidature.*, poste.libelle AS libelle_poste 
                                              FROM candidature 
                                              INNER JOIN poste 
                                              ON candidature.codeP = poste.codeP 
                                              WHERE candidature.etat = 'accepte'");

        echo "<h3>Candidats acceptés:</h3>";
        affichage($candidatAccepte);

        $candidatRefuse = $cnx->query("SELECT candidature.*, poste.libelle AS libelle_poste 
                                              FROM candidature 
                                              INNER JOIN poste 
                                              ON candidature.codeP = poste.codeP 
                                              WHERE candidature.etat = 'refuse'");

        echo "<h3>Candidats refusés:</h3>";


        function affichage($candidat) {
            echo "<table>";
            echo "<tr> 
                <th>CIN</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Date de Naissance</th>
                <th>Email</th>
                <th>Poste</th>
                <th colspan='2'>Action</th>
                </tr>";
            while ($donnee = $candidat->fetch(PDO::FETCH_ASSOC)) {
                echo "<tr>";
                echo "<td>".$donnee['CIN_candida']."</td>";
                echo "<td>".$donnee['nom']."</td>";
                echo "<td>".$donnee['prenom']."</td>";
                echo "<td>".$donnee['date_naissance']."</td>";
                echo "<td>".$donnee['email']."</td>";
                echo "<td>".$donnee['libelle_poste']."</td>";
                echo "<td><a href=modifierCandidat.php?id_candida=" . $donnee['id_candida'] .">modifier</a></td>";
                echo "<td><a href=../fiche/affichageFiche.php?id_candida=" . $donnee['id_candida'] . ">fiche evaluation</a></td>";
                echo "</tr>";
            }
            echo "</table>";
        }


        echo "<table>";
            echo "<tr> 
                <th>CIN</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Date de Naissance</th>
                <th>Email</th>
                <th>Poste</th>
                <th colspan='2'>Action</th>
                </tr>";
            while ($donnee = $candidatRefuse->fetch(PDO::FETCH_ASSOC)) {
                echo "<tr>";
                echo "<td>".$donnee['CIN_candida']."</td>";
                echo "<td>".$donnee['nom']."</td>";
                echo "<td>".$donnee['prenom']."</td>";
                echo "<td>".$donnee['date_naissance']."</td>";
                echo "<td>".$donnee['email']."</td>";
                echo "<td>".$donnee['libelle_poste']."</td>";
                echo "<td><a href=../fiche/affichageFiche.php?id_candida=" . $donnee['id_candida'] . ">fiche evaluation</a></td>";
                echo "</tr>";
            }
            echo "</table>";

       
    ?>
</body>
</html>
