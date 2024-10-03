<!DOCTYPE html>
<html>
<head>
    <title>Validation des dates de naissance</title>
</head>
<body>
    <h2>Validation des dates de naissance</h2>
    <form method="post">
        <label for="nom">Entrez le nom de l'étudiant : </label>
        <input type="text" name="nom" id="nom">
        <br>
        <label for="date">Entrez la date de naissance (JJ/MM/AAAA) : </label>
        <input type="text" name="date" id="date">
        <input type="submit" value="Valider">
    </form>

    <?php
    function VerifdateNaiss($date) {
        $dateElements = explode('/', $date);
        if (count($dateElements) == 3) {
            $jour = (int)$dateElements[0];
            $mois = (int)$dateElements[1];
            $annee = (int)$dateElements[2];
            if (checkdate($mois, $jour, $annee)) {
                return true;
            }
        }
        return false;
    }

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $nom = $_POST["nom"];
        $date = $_POST["date"];
        if (!empty($nom) && VerifdateNaiss($date)) {
            $dateElements = explode('/', $date);
            $jour = $dateElements[0];
            $mois = $dateElements[1];
            $annee = $dateElements[2];
    ?>
    <h2>Résultat (affichage)</h2>
    <table border="1">
        <tr>
            <th>Nom</th>
            <th>Jours</th>
            <th>Mois</th>
            <th>Annee</th>
        </tr>
        <tr>
            <td><?php echo $nom; ?></td>
            <td><?php echo $jour; ?></td>
            <td><?php echo $mois; ?></td>
            <td><?php echo $annee; ?></td>
        </tr>
    </table>
    <?php
        } else {
            echo "Veuillez entrer un nom et une date de naissance valide au format JJ/MM/AAAA.";
        }
    }
    ?>
</body>
</html>
