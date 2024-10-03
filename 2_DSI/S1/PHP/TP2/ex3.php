<!DOCTYPE html>
<html>
<body>
    <h1>Vérification de multiplicité</h1>
    <form method="post" action="ex3.php">
        Entrez un nombre :
        <input type="text" name="nb">
        <button>Check</button>
    </form>
    <?php
        $nb = $_POST['nb'];

        if ($nb % 3 == 0 && $nb % 5 == 0) {
            echo "$nb est à la fois un multiple de 3 et de 5.";
        } else {
            echo "$nb n'est pas un multiple de 3 et de 5 à la fois.";
        }
    ?>

</body>
</html>