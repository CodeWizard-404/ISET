<?php
    include("../bd/connexion.php");
    $modeleName = $_POST['modeleName'];
    $description = $_POST['description'];
    $poste= $_POST['poste'];
    $sql = "INSERT INTO modeleevaluation (lib_modele, description,codeP) VALUES ('$modeleName', '$description','$poste')";
    $id = $cnx->lastInsertId();
    $sql = "UPDATE poste SET id = '$id' WHERE codeP = '$poste'";
    $cnx->query($sql);

    // $competence = $_POST['competence'];
    // $coef = $_POST['coef'];
    // $sql = "INSERT INTO evaluationcompetence VALUES ('$id','$competence','$coef')";
    // $cnx->query($sql);

    // $counter = $_POST['counter'];
    // if($counter > 1) {
    //     for($i = 1; $i <= $counter; $i++) {
    //         $comp = 'competence_' . $i;
    //         $coef = 'coef_' . $i;  

    //         if(isset($_POST[$coef]) && isset($_POST[$comp])) {
    //             $coef = $_POST[$coef];
    //             $comp= $_POST[$comp];

    //             $sql = "INSERT INTO evaluationcompetence VALUES ('$id','$comp','$coef')";
    //             $cnx->query($sql);
    //         }
    //     }
    // }

?>
    