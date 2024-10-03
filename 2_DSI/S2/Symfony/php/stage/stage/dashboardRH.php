<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>administrateur</title>
    <style>
        tr,td,table{
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <?php
            echo("<tr><td><a href='candidat/ajouterCandidat.php'> ajouter candidat </a></td></tr>");
            echo("<tr><td><a href='fiche/fiche.php'> evaluer candidat </a></td></tr>");
            echo("<tr><td><a href='candidat/afficherCandidat.php'> afficher candidat </a></td></tr>");
            echo("<tr><td><a href='poste/ajoutPoste.php'> ajouter poste </a></td></tr>");
            echo("<tr><td><a href='poste/afficherPoste.php'> afficher poste </a></td></tr>");
            echo("<tr><td><a href='competence/afficherCompetence.php'> afficher competence </a></td></tr>");
            echo("<tr><td><a href='competence/ajoutCompetence.php'> ajouter competence </a></td></tr>");
            echo("<tr><td><a href='modeleEvaluation/ajout.php'> ajouter modele evaluation </a></td></tr>");
            echo("<tr><td><a href='ModeleEvaluation/affichage.php'> afficher modele evaluation </a></td></tr>");
            echo("<tr><td><a href='deconnexion.php'> logout </a></td></tr>");
        ?>
    </table>
</body>
</html>
