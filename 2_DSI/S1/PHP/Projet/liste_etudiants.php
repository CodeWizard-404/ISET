<?php
include 'connexion.php';

$query = $pdo->query("SELECT * FROM Etudiant");
$etudiants = $query->fetchAll(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Étudiants</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            padding: 20px;
        }
        table {
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2 class="mt-3">Liste des Étudiants</h2>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>NCE</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Classe</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($etudiants as $etudiant) : ?>
                    <tr>
                        <td><?php echo $etudiant['NCE']; ?></td>
                        <td><?php echo $etudiant['nom']; ?></td>
                        <td><?php echo $etudiant['prenom']; ?></td>
                        <td><?php echo $etudiant['classe']; ?></td>
                        <td>
                            <a href="supprimer_etudiant.php?nce=<?php echo $etudiant['NCE']; ?>" class="btn btn-danger">Supprimer</a>
                            <a href="modifier_etudiant.php?nce=<?php echo $etudiant['NCE']; ?>" class="btn btn-primary">Modifier</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>

        <a href="administration.php" class="btn btn-secondary mt-3">Retour</a>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
