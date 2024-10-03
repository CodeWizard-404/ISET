
<?php
session_start();
if(!isset($_SESSION["user"]))
    {
    	echo '<script>alert("Session expirée")</script>';
    }
else
{
?>

<?php
include('db_config.php');
?>

<html>

<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<style>
		
	</style>
</head>

<body>
	<div class="container">
		<br />
		<form action="save.php" method="post">
		libelle modele:
        <input type="text" name="modeleName" required> <br>
        description du modele
        <input type="text" name="description" required> <br>
        modele pour poste:
        <select name="poste">
            <?php
            include("../bd/connexion.php");
            $res = $cnx->query("SELECT * FROM poste WHERE activé=true");
            while ($donnee = $res->fetch(PDO::FETCH_ASSOC)) {
                echo "<option value=" . $donnee['libellePoste'] . ">" . $donnee['libellePoste'] . "</option>";
            }
            ?>
        </select>
			<div >
				<label for="competence">competence</label>
				<select class="form-control competence" name="competence">
					<option value="">Select competence</option>
					<?php
					$query = "SELECT * FROM competence";
					$result = $cnx->query($query);
					if ($result->rowCount() > 0) {
						while ($row = $result->fetch(PDO::FETCH_ASSOC)) {
							echo '<option value="' . $row['libelle'] . '">' . $row['libelle'] . '</option>';
						}
					} else {
						echo '<option value="">il faut ajouter des competences!!</option>';
					}
					?>
				</select>
				<!-- <br /> -->
				<!-- <label for="niveau">niveau</label>
				<select class="form-control niveau" name="niveau">
					<option value="">Select niveau</option>
				</select> -->
				<!-- <br> -->
				<input type="number" name="ponderation" placeholder="Entrer votre ponderation">
				<button type="button" class="btn btn-danger btn-sm remove-btn">-</button>
			</div>
			<button type="button" class="btn btn-success" id="addCompetence">+</button>
			<input type="hidden" name="counter" id="counter" value="1">

			<input type="submit" name="ajout" class="btn btn-success">
		</form>
	</div>

	<script>
    var counterInput = document.getElementById('counter');
    var counter = parseInt(counterInput.value);

    $(document).on("change", ".competence", function () {
        var libelleCompetence = $(this).val();
        var competenceDiv = $(this).closest('div');
        var niveauDropdown = competenceDiv.find('.niveau');
        var ponderationInput = competenceDiv.find('input[name^="ponderation"]');
        $.ajax({
            url: "action.php",
            type: "POST",
            cache: false,
            data: {
                libelleCompetence: libelleCompetence
            },
            success: function (data) {
                niveauDropdown.html(data);
            }
        });
    });

    $("#addCompetence").click(function () {
        var newDropdown =
            `<div><label for="competence">competence</label>
        <select class="form-control competence" name="competence_${counter}">
            <option value="">Select competence</option>
            <?php $query = "SELECT * FROM competence";
            $result = $cnx->query($query);
            if ($result->rowCount() > 0) {
                while ($row = $result->fetch(PDO::FETCH_ASSOC)) {
                    echo '<option value="' . $row['libelleCompetence'] . '">' . $row['libelleCompetence'] . '</option>';
                }
            } else {
                echo '<option value="">competence not available</option>';
            }
            ?>
        </select>
        
        <input type="number" name="ponderation_${counter}" placeholder="Entrer votre ponderation">
        <button type="button" class="btn btn-danger btn-sm remove-btn">-</button></div>`;
        $(this).before(newDropdown);
        counter++;
        counterInput.value = counter;
    });

    $(document).on("click", ".remove-btn", function () {
        $(this).closest('div').remove();
    });

    $("form").submit(function (e) {
        var totalPonderation = 0;

        $('input[name^="ponderation"]').each(function () {
            totalPonderation += parseInt($(this).val());
        });

        if (totalPonderation > 100) {
            alert(
"Le total de la coef ne doit pas dépasser 100.");
            e.preventDefault(); 
        }
    });
</script>

</body>

</html>
<?php
}
?>