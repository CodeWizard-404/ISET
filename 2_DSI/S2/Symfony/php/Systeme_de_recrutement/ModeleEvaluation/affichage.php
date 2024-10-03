
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
    <form method="GET">
        modele pour poste:
        <select name="poste" id="post">
            <?php
            include("db_config.php");
            $res = $cnx->query("SELECT * FROM poste WHERE activé=true");
            while ($donnee = $res->fetch(PDO::FETCH_ASSOC)) {
                echo "<option value=" . $donnee['libellePoste'] . ">" . $donnee['libellePoste'] . "</option>";
            }
            ?>
        </select>
        <div id="modeleContainer"></div>
        <div id="competenceContainer"></div>
        <button id="deleteModelButton" style="display:none;">Delete Model</button>
    </form>

    <script>
        $(document).ready(function () {
            $('#post').change(function () {
                var libellePost = $(this).val();
                $.ajax({
                    type: 'GET',
                    url: 'get_modeles.php',
                    data: {
                        post: libellePost
                    },
                    success: function (data) {
                        $('#modeleContainer').html(data);
                        $('#competenceContainer').html("");
                        $('#deleteModelButton').hide();
                    }
                });
            });

            $(document).on('change', '#modele', function () {
                var modele = $(this).val();
                $('#deleteModelButton').show();
                $.ajax({
                    type: 'GET',
                    url: 'get_competences.php',
                    data: {
                        modele: modele
                    },
                    success: function (data) {
                        $('#competenceContainer').html(data);
                    }
                });
            });

            $(document).on('click', '#deleteModelButton', function () {
                var modele = $('#modele').val();
                $.ajax({
                    type: 'POST',
                    url: 'supprimer.php',
                    data: {
                        modele: modele
                    },
                    success: function (response) {
                        console.log(response);
                        console.log("done");
                    },
                    error: function (error) {
                        console.log("Error:", error);
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