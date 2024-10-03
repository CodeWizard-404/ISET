<?php
include 'connexion.php';

$message = '';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nce = $_POST['nce'];
    $nom = $_POST['nom'];
    $prenom = $_POST['prenom'];
    $classe = $_POST['classe'];

    try {
        $query = $pdo->prepare("INSERT INTO Etudiant (NCE, nom, prenom, classe) VALUES (:nce, :nom, :prenom, :classe)");
        $query->bindParam(':nce', $nce, PDO::PARAM_INT);
        $query->bindParam(':nom', $nom, PDO::PARAM_STR);
        $query->bindParam(':prenom', $prenom, PDO::PARAM_STR);
        $query->bindParam(':classe', $classe, PDO::PARAM_STR);

        if ($query->execute()) {
            $message = "Étudiant ajouté avec succès.";
        } else {
            $message = "Erreur lors de l'ajout de l'étudiant.";
        }
    } catch (PDOException $e) {
        $message = "Erreur : " . $e->getMessage();
    }
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter Étudiant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 400px;
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
        input[type="text"] {
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
        <h2 class="mb-4">Ajouter Étudiant</h2>

        <?php if (!empty($message)) : ?>
            <div class="alert alert-<?php echo ($message == "Étudiant ajouté avec succès.") ? 'success' : 'danger'; ?>" role="alert">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <form method="post" action="">
            <div class="mb-3">
                <label for="nce" class="form-label">NCE:</label>
                <input type="text" name="nce" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="nom" class="form-label">Nom:</label>
                <input type="text" name="nom" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom:</label>
                <input type="text" name="prenom" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="classe" class="form-label">Classe:</label>
                <input type="text" name="classe" class="form-control" required>
            </div>

            <input type="submit" value="Ajouter" class="btn btn-primary">
        </form>
        <a href="administration.php" class="btn btn-secondary mt-3">Retour</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
