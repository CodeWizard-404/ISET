<?php
include 'connexion.php';

$queryEtudiants = $pdo->query("SELECT NCE, nom, prenom FROM Etudiant");
$queryEnseignants = $pdo->query("SELECT Matricule, nom_Ens, prenom_Ens FROM Enseignant");

$etudiants = $queryEtudiants->fetchAll(PDO::FETCH_ASSOC);
$enseignants = $queryEnseignants->fetchAll(PDO::FETCH_ASSOC);

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $numjury = $_POST['numjury'];
    $date_soutenance = $_POST['date_soutenance'];
    $note = $_POST['note'];
    $nce = $_POST['nce'];
    $matricule = $_POST['matricule'];

    try {
        $query = $pdo->prepare("INSERT INTO Soutenance (Numjury, date_soutenance, note, Nce, Matricule) VALUES (:numjury, :date_soutenance, :note, :nce, :matricule)");
        $query->bindParam(':numjury', $numjury, PDO::PARAM_INT);
        $query->bindParam(':date_soutenance', $date_soutenance, PDO::PARAM_STR);
        $query->bindParam(':note', $note, PDO::PARAM_STR);
        $query->bindParam(':nce', $nce, PDO::PARAM_INT);
        $query->bindParam(':matricule', $matricule, PDO::PARAM_INT);

        if ($query->execute()) {
            $message = 'Soutenance ajoutée avec succès.';
        } else {
            $message = 'Erreur lors de l\'ajout de la soutenance.';
        }
    } catch (PDOException $e) {
        $message = 'Erreur : ' . $e->getMessage();
    }
}

?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter Soutenance</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #dcdcdc;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        form {
            margin-top: 20px;
        }
        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2 class="mb-4">Ajouter Soutenance</h2>

        <?php if (!empty($message)) : ?>
            <div class="alert alert-<?php echo ($message == "Soutenance ajoutée avec succès.") ? 'success' : 'danger'; ?>" role="alert">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <form method="post" action="">
            <div class="mb-3">
                <label for="numjury" class="form-label">Numéro de Jury:</label>
                <input type="text" name="numjury" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="date_soutenance" class="form-label">Date de Soutenance:</label>
                <input type="date" name="date_soutenance" class="form-control" value="2023-12-15" required>
            </div>

            <div class="mb-3">
                <label for="note" class="form-label">Note:</label>
                <input type="text" name="note" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="nce" class="form-label">Étudiant:</label>
                <select name="nce" class="form-select" required>
                    <?php foreach ($etudiants as $etudiant) : ?>
                        <option value="<?php echo $etudiant['NCE']; ?>"><?php echo $etudiant['nom'] . ' ' . $etudiant['prenom']; ?></option>
                    <?php endforeach; ?>
                </select>
            </div>

            <div class="mb-3">
                <label for="matricule" class="form-label">Enseignant:</label>
                <select name="matricule" class="form-select" required>
                    <?php foreach ($enseignants as $enseignant) : ?>
                        <option value="<?php echo $enseignant['Matricule']; ?>"><?php echo $enseignant['nom_Ens'] . ' ' . $enseignant['prenom_Ens']; ?></option>
                    <?php endforeach; ?>
                </select>
            </div>

            <input type="submit" value="Ajouter" class="btn btn-primary">
        </form>
        <a href="administration.php" class="btn btn-secondary mt-3">Retour</a>
</a>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
