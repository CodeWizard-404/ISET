<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>


<body>
    <form method="post" action="ex2.php">
        Entrez une adresse : <input type="text" name="adresse">
        <input type="submit" value="Valider">
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $adresse = $_POST["adresse"];
        $regex = '/^www[.a-zA-Z-]*[.][a-zA-Z]{2,4}$/';
        if (preg_match($regex, $adresse)) {
            echo "L'adresse est valide.";
        } else {
            echo "L'adresse n'est pas valide.";
        }
    }
    ?>

</body>

</html>