<!DOCTYPE html>
<html lang="en">
<body>
    <form method="post" action="ex1.php">
        Entrez l'âge : <input type="text" name="age">
        <input type="submit" value="Valider">
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $age = $_POST["age"];
        $regex = '/^\d{1,2}$/';
        if (preg_match($regex, $age)) {
            echo "L'âge est valide.";
        } else {
            echo "L'âge n'est pas valide.";
        }
    }
    ?>

</body>

</html>