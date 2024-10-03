
<?php
session_start();
if(!isset($_SESSION["user"]))
    {
    	echo '<script>alert("Session expirée")</script>';
    }
else
{
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>

<body>
    <form action="save.php" method="POST">
    Evaluer par:
    <select name="recruteur">
        <option value="">nom du recruteur:</option>
        <?php
        include("db_config.php");
        $res = $cnx->query("SELECT * FROM recruteur");
        while ($donnee = $res->fetch(PDO::FETCH_ASSOC)) {
            echo "<option value=" . $donnee['CINrecruteur'] . ">" . $donnee['nom'] . "</option>";
        }
        ?>
    </select>
    <br> nom de candidat:
    <select name="candidat" id="candidat">
        <option value="">nom du candidat:</option>
        <?php
        $res = $cnx->query("SELECT * FROM candidat");
        while ($donnee = $res->fetch(PDO::FETCH_ASSOC)) {
            echo "<option value=" . $donnee['CINcandidat'] . ">" . $donnee['nom'] . "</option>";
        }
        ?>
    </select>
    <br> choix du poste:
    <p name="libelleposte" id="libelleposte"></p>
    <br> modele:
    <div id="modeleContainer"></div>
    <div id="competenceContainer"></div>
    <input type="submit" name="ajout">
    </form>
    <script>
        $(document).ready(function () {
            $('#candidat').change(function () {
                var candidatId = $(this).val();
                console.log(candidatId)
                $.ajax({
                    type: 'GET',
                    url: 'get_job_position.php',
                    data: {
                        candidat: candidatId
                    },
                    success: function (data) {
                        $('#libelleposte').html(data);
                        $('#competenceContainer').html("");
                        console.log(data)
                    }
                });
            });

            $('#candidat').change(function () {
                var candidatId = $(this).val();
                console.log("candidatId:", candidatId);
                $.ajax({
                    type: 'GET',
                    url: 'get_modeles.php',
                    data: {
                        candidat: candidatId
                    },
                    success: function (data) {
                        $('#modeleContainer').html(data);
                        console.log(data);
                    }
                });
            });

            $(document).on('change', '#modele', function () {
                var modele = $(this).val();
                console.log("Selected Modele:", modele);
                $.ajax({
                    type: 'GET',
                    url: 'get_competences.php',
                    data: {
                        candidat: $('#candidat').val(),
                        modele: modele
                    },
                    success: function (data) {
                        $('#competenceContainer').html(data);
                        console.log(data);
                    }
                });
            });
        });
    </script>
</body>

</html>
<?php
}
?>