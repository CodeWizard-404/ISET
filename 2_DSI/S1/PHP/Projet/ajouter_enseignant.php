<?php
include 'connexion.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $matricule = $_POST['matricule'];
    $nom_ens = $_POST['nom_ens'];
    $prenom_ens = $_POST['prenom_ens'];

    try {
        $query = $pdo->prepare("INSERT INTO Enseignant (Matricule, nom_Ens, prenom_Ens) VALUES (:matricule, :nom_ens, :prenom_ens)");
        $query->bindParam(':matricule', $matricule, PDO::PARAM_INT);
        $query->bindParam(':nom_ens', $nom_ens, PDO::PARAM_STR);
        $query->bindParam(':prenom_ens', $prenom_ens, PDO::PARAM_STR);

        if ($query->execute()) {
            $message = "Enseignant ajouté avec succès.";
        } else {
            $message = "Erreur lors de l'ajout de l'enseignant.";
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
    <title>Ajouter Enseignant</title>
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
        <h2 class="mb-4">Ajouter Enseignant</h2>

        <?php if (!empty($message)) : ?>
            <div class="alert alert-<?php echo ($message == "Enseignant ajouté avec succès.") ? 'success' : 'danger'; ?>" role="alert">
                <?php echo $message; ?>
            </div>
        <?php endif; ?>

        <form method="post" action="">
            <div class="mb-3">
                <label for="matricule" class="form-label">Matricule:</label>
                <input type="text" name="matricule" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="nom_ens" class="form-label">Nom:</label>
                <input type="text" name="nom_ens" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="prenom_ens" class="form-label">Prénom:</label>
                <input type="text" name="prenom_ens" class="form-control" required>
            </div>

            <input type="submit" value="Ajouter" class="btn btn-primary">
            
        </form>
        <a href="administration.php" class="btn btn-secondary mt-3">Retour</a>
</a>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
