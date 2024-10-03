<?php
include 'connexion.php';

$message = '';

if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['nce'])) {
    $nce = $_GET['nce'];

    try {
        $query = $pdo->prepare("DELETE FROM Etudiant WHERE NCE = :nce");
        $query->bindParam(':nce', $nce, PDO::PARAM_INT);

        if ($query->execute()) {
            $message = "Étudiant supprimé avec succès.";
        } else {
            $message = "Erreur lors de la suppression de l'étudiant.";
        }
    } catch (PDOException $e) {
        $message = "Erreur : " . $e->getMessage();
    }
}

header("Location: liste_etudiants.php");
exit();
?>
