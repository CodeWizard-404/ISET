<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

</body>

</html>

<body>
    <form method="post" action="validation_email.php">
        Entrez une adresse e-mail : <input type="text" name="email">
        <input type="submit" value="Valider">
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $email = $_POST["email"];
        $regex = '/^[a-zA-Z][a-zA-Z0-9.-]*@[a-zA-Z]{2,}\.[a-zA-Z]{2,4}$/';
        if (preg_match($regex, $email)) {
            echo "L'adresse e-mail est valide.";
        } else {
            echo "L'adresse e-mail n'est pas valide.";
        }
    }
    ?>

</body>

</html>