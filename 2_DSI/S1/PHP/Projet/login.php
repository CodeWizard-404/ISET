<?php
function authenticate($login, $mot_de_passe, $pdo)
{
    $query = $pdo->prepare("SELECT * FROM administrateur WHERE login = :login AND mot_de_passe = :mot_de_passe");
    $query->bindParam(':login', $login, PDO::PARAM_STR);
    $query->bindParam(':mot_de_passe', $mot_de_passe, PDO::PARAM_STR);
    $query->execute();
    return $query->fetch(PDO::FETCH_ASSOC);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    include 'connexion.php';

    $login = $_POST['login'];
    $mot_de_passe = $_POST['mot_de_passe'];

    $admin = authenticate($login, $mot_de_passe, $pdo);

    if ($admin) {
        $_SESSION['admin_id'] = $admin['id_admin'];
        header("Location: administration.php");
        exit();
    } else {
        $messageErreur = "Identifiant ou mot de passe incorrect.";
    }
}
?>
