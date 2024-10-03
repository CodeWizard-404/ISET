<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erreur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8d7da;
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

        .alert {
            margin-top: 20px;
        }

        a {
            text-decoration: none;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 10px;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            text-transform: uppercase;
            cursor: pointer;
            border-radius: 5px;
        }

        .btn-primary {
            color: #fff;
            background-color: #007bff;
            border: none;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-secondary {
            color: #212529;
            background-color: #f8f9fa;
            border: 1px solid #dcdcdc;
        }

        .btn-secondary:hover {
            background-color: #e2e6ea;
        }
    </style>
</head>

<body>
    <div class="container">
        <h2 class="mb-4">Erreur</h2>
        <div class="alert alert-danger" role="alert">
            <?php echo $message; ?>
        </div>
        <a href="liste_etudiants.php" class="btn btn-secondary mt-3">Retour</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
