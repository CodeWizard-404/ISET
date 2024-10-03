<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<style>
		
	</style>
</head>
<body>
	<div class="container">
		<br/>
		<form action="save.php" method="post">
		libelle modele:
        <input type="text" name="modeleName" required> <br>
        description du modele
        <input type="text" name="description" required> <br>
        <p style="color:red">remarque: si vous ne trouvez pas le poste cherchez ce que le poste a deja un modele d'evauation </p>
        modele pour poste: <br>
        <select name="poste" required>
            <option value="null">choix du poste</option>
            <?php
                include("../bd/connexion.php");
                $res = $cnx->query("SELECT * FROM poste WHERE actif=true AND id IS NULL");
                while ($donnee = $res->fetch(PDO::FETCH_ASSOC)) {
                    echo "<option value=" . $donnee['codeP'] . ">" . $donnee['libelle'] . "</option>";
                }
            ?>
        </select>
			<div >
				<label for="competence">competence</label>
				<select class="form-control competence" name="competence">
					<option value="null">Select competence</option>
					<?php
					$query = "SELECT * FROM competence";
					$result = $cnx->query($query);
					if ($result->rowCount() > 0) {
						while ($row = $result->fetch(PDO::FETCH_ASSOC)) {
							echo '<option value="' . $row['libelle'] . '">' . $row['libelle'] . '</option>';
						}
					} else {
						echo '<option value="null">il faut ajouter des competences!!</option>';
					}
					?>
				</select>
				<input type="number" name="coef" placeholder="Entrer votre coef" required>
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

        $("#addCompetence").click(function () {
            var newDropdown =
                `<div><label for="competence">competence</label>
                <select class="form-control competence" name="competence_${counter}">
                <option value="null" required>Select competence</option>
                <?php $query = "SELECT * FROM competence";
                $result = $cnx->query($query);
                if ($result->rowCount() > 0) {
                    while ($row = $result->fetch(PDO::FETCH_ASSOC)) {
                        echo '<option value="' . $row['libelle'] . '">' . $row['libelle'] . '</option>';
                    }
                } else {
                    echo '<option value="null">il faut ajouter des competences!!</option>';
                }
                ?>
            </select>
            
            <input type="number" name="coef_${counter}" placeholder="Entrer votre coef" required>
            <button type="button" class="btn btn-danger btn-sm remove-btn">-</button></div>`;
            $(this).before(newDropdown);
            counter++;
            counterInput.value = counter;
        });

        $(document).on("click", ".remove-btn", function () {
            $(this).closest('div').remove();
        });

        $("form").submit(function (e) {
            var totalcoef = 0;

            $('input[name^="coef"]').each(function () {
                totalcoef += parseInt($(this).val());
            });

            if (totalcoef > 100) {
                alert("Le total de la coef ne doit pas dépasser 100.");
                e.preventDefault(); 
            }
        });
</script>
</body>
