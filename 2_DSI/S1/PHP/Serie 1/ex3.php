<!DOCTYPE html>
<html>
<head>
    <title>Formulaire de saisie d'adresse e-mail</title>
</head>
<body>
    <h2>Formulaire de saisie d'adresse e-mail</h2>
    <form method="post" action="ex3.php">
        <input type="hidden" name="browser" value="
        <?php echo $_SERVER['HTTP_USER_AGENT']; ?>">

        <label for="email">Adresse e-mail :</label>
        <input type="email" id="email" name="email" required>
        <input type="submit" value="Valider">
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] === "POST") {
        $email = $_POST["email"];
        
        $browser = $_POST["browser"];
        
        echo "<h2>Données saisies :</h2>";
        echo "<p>Adresse e-mail : $email</p>";
        echo "<p>Type de navigateur : $browser</p>";
    }
    ?>
</body>
</html>
