<html>
<body>
    <h1>Vérification de parité</h1>
    <form method="get" action="ex2.php">
        Entrez un nombre :
        <input type="text" name="nb">
        <button>Check</button>
    </form>
    <?php
        $nb = $_GET['nb'];

        if ($nb % 2 == 0) {
            echo "Le nombre $nb est pair.";
        } else {
            echo "Le nombre $nb est impair.";
        }
    ?>

</body>
</html>