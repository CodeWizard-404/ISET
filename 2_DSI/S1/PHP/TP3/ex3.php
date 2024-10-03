<?php
$TMOTS = array(
    "Utilisateur1" => "MotDePasse1",
    "Utilisateur2" => "MotDePasse2",
    "Utilisateur3" => "MotDePasse3",
    "Utilisateur4" => "MotDePasse4"
);

if (isset($_POST['selectedUser'])) {
    $selectedUser = $_POST['selectedUser'];
    echo "Le mot de passe de $selectedUser est : " . $TMOTS[$selectedUser];

}

if (isset($_POST['selectedPassword'])) {
    $selectedPassword = $_POST['selectedPassword'];
    $user = array_search($selectedPassword, $TMOTS);
    echo "L'utilisateur associé au mot de passe $selectedPassword est : $user";

}
?>

<form method="post">
    <label for="selectedUser">Sélectionner une personne :</label>
    <select name="selectedUser" id="selectedUser">
        <?php
        foreach ($TMOTS as $user => $password) {
            echo "<option value='$user'>$user</option>";
        }
        ?>
    </select>
    <input type="submit" value="Afficher le mot de passe">
</form>

<form method="post">
    <label for="selectedPassword">Sélectionner un mot de passe :</label>
    <select name="selectedPassword" id="selectedPassword">
        <?php
        foreach ($TMOTS as $user => $password) {
            echo "<option value='$password'>$password</option>";
        }
        ?>
    </select>
    <input type="submit" value="Afficher l'utilisateur associé">
</form>