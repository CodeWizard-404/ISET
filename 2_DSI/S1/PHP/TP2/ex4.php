<!DOCTYPE html>
<html>

<body>
    <h1>Mention étudiant</h1>
    <form method="post" action="ex4.php">
        Entrez la moyenne générale :
        <input type="text" name="moy">
        <button>Check</button>
    </form>
    <?php
        $moy =$_POST['moy'];

        if ($moy < 10) {
            echo "Mention : Échec";
        } elseif ($moy >= 10 && $moy < 12) {
            echo "Mention : Passable";
        } elseif ($moy >= 12 && $moy < 14) {
            echo "Mention : Assez bien";
        } elseif ($moy >= 14 && $moy < 16) {
            echo "Mention : Bien";
        } else {
            echo "Mention : Très bien";
        }
    ?>

</body>

</html>