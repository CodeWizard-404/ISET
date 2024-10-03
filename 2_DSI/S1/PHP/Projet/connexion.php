<?php
include 'dbconfig.php';

try {
    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    echo "<script>Connexion réussie</script>";
} catch (PDOException $e) {
    echo "<script>Erreur de connexion : " . $e->getMessage() . "</script>";
}
?>
