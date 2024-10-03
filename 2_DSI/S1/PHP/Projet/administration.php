<?php
session_start();

if (!isset($_SESSION['admin_id'])) {
    header("Location: index.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .dashboard {
            padding: 20px;
        }
        .card {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

    <div class="container dashboard">
        <h2 class="mt-3 mb-4">Admin Dashboard</h2>

        <form action="rechercher.php" method="post" class="mb-4">
            <div class="input-group">
                <button type="submit" class="btn btn-primary">Rechercher</button>
            </div>
        </form>


        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajouter un enseignant</h5>
                        <p class="card-text">Ajouter un nouvel enseignant.</p>
                        <a href="ajouter_enseignant.php" class="btn btn-primary">Ajouter</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajouter un soutenance</h5>
                        <p class="card-text">Ajouter un nouvel soutenance.</p>
                        <a href="ajouter_soutenance.php" class="btn btn-primary">Ajouter</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajouter un étudiant</h5>
                        <p class="card-text">Ajouter un nouvel étudiant.</p>
                        <a href="ajouter_etudiant.php" class="btn btn-primary">Ajouter</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Liste des étudiants</h5>
                        <p class="card-text">Afficher la liste des étudiants.</p>
                        <a href="liste_etudiants.php" class="btn btn-primary">Afficher</a>
                    </div>
                </div>
            </div>
        </div>

        <a href="logout.php" class="btn btn-danger mt-4">Déconnexion</a>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
