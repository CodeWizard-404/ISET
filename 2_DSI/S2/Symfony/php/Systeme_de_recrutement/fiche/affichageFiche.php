<?php
session_start();
if (!isset($_SESSION["user"])) {
    echo '<script>alert("Session expirée")</script>';
} else {
    include("db_config.php");
    $CINcandidat = $_GET['CINcandidat'];
    $fiche = $cnx->query("SELECT * from ficheevaluation WHERE CINcandidat='$CINcandidat'");
    if ($fiche->rowCount() > 0) {
        echo "<head><style>
        table {
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid ;
        }

    </style> </head>";
        echo"<h2>Fiche Evaluation</h2>
        <table>
        
            <tr>
                <th>modele:</th>
                <th>nom du recruteur</th>
                <th>son evaluation</th>
                <th>note pour ce modele</th>
            </tr>";

        while ($donnee = $fiche->fetch(PDO::FETCH_ASSOC)) {
            echo "<tr>";
            echo "<td>" . $donnee['libelleModele'] . "</td>";
            $recru = $cnx->query("SELECT nom FROM recruteur WHERE CINrecruteur='" . $donnee['CINrecruteur'] . "'");
            $nomRecruteur = $recru->fetch(PDO::FETCH_ASSOC)['nom'];
            echo "<td>" . $nomRecruteur . "</td>";

            $competenceList = json_decode($donnee['competenceList'], true);
            $totalScore = 0;

            echo "<td>";
            foreach ($competenceList as $competence => $level) {
                echo "$competence: $level<br>";
                $res = $cnx->query("SELECT ponderation FROM modelecompetence WHERE libellecompetence='$competence' AND libelléModele='" . $donnee['libelleModele'] . "'");
                $ponderation = $res->fetch(PDO::FETCH_ASSOC)['ponderation'];

                $lvl = $cnx->query("SELECT note FROM niveau WHERE libelleCompetence='$competence' AND niveau='$level'");
                $levelNote = $lvl->fetch(PDO::FETCH_ASSOC)['note'];

                $score = $levelNote * $ponderation;
                $totalScore += $score;
            }
            echo "</td>";
            echo "<td>$totalScore</td>";
            echo "</tr>";
        }
    } else {
        echo "ce candidat n'a pas de fiche d'evaluation";
    }
}
?>
