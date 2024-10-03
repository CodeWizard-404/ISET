<?php
include 'connexion.php';

$queryEnseignants = $pdo->query("SELECT Matricule, nom_Ens, prenom_Ens FROM Enseignant");
$enseignants = $queryEnseignants->fetchAll(PDO::FETCH_ASSOC);

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['matricule'])) {
    $matricule = $_POST['matricule'];

    $query = $pdo->prepare("SELECT * FROM Soutenance WHERE Matricule = :matricule AND date_soutenance = '2023-12-15'");
    $query->bindParam(':matricule', $matricule, PDO::PARAM_INT);
    $query->execute();
    $soutenances = $query->fetchAll(PDO::FETCH_ASSOC);
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rechercher Soutenances</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #dee2e6;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        .btn-back {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

    <h2>Rechercher Soutenances</h2>
    <form method="post" action="">
        <label for="matricule">Sélectionner un enseignant:</label>
        <select name="matricule" required class="form-select">
            <?php foreach ($enseignants as $enseignant) : ?>
                <option value="<?php echo $enseignant['Matricule']; ?>"><?php echo $enseignant['nom_Ens'] . ' ' . $enseignant['prenom_Ens']; ?></option>
            <?php endforeach; ?>
        </select><br>

        <input type="submit" value="Rechercher" class="btn btn-primary">
    </form>

    <?php if (isset($soutenances)) : ?>
        <h3>Résultats de la recherche:</h3>
        <?php if (empty($soutenances)) : ?>
            <p>Aucune soutenance trouvée pour cet enseignant à la date spécifiée.</p>
        <?php else : ?>
            <table>
                <tr>
                    <th>Numéro de Jury</th>
                    <th>Date de Soutenance</th>
                    <th>Note</th>
                    <th>NCE Étudiant</th>
                    <th>Matricule Enseignant</th>
                </tr>
                <?php foreach ($soutenances as $soutenance) : ?>
                    <tr>
                        <td><?php echo $soutenance['Numjury']; ?></td>
                        <td><?php echo $soutenance['date_soutenance']; ?></td>
                        <td><?php echo $soutenance['note']; ?></td>
                        <td><?php echo $soutenance['Nce']; ?></td>
                        <td><?php echo $soutenance['Matricule']; ?></td>
                    </tr>
                <?php endforeach; ?>
            </table>
        <?php endif; ?>
    <?php endif; ?>
    <a href="administration.php" class="btn btn-secondary mt-3">Retour</a>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
