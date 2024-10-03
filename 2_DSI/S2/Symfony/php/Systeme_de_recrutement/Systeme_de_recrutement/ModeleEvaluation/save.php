
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
    include ("db_config.php");
    $modeleName = $_POST['modeleName'];
    $description = $_POST['description'];
    $poste= $_POST['poste'];
    $sql = "INSERT INTO modeleevaluation (libelléModele, description,libelleposte) VALUES ('$modeleName', '$description','$poste')";
    $cnx->query($sql);


    $competence = $_POST['competence'];
    $ponderation = $_POST['ponderation'];

    $id = $_POST['niveau'];
    $sql="SELECT niveau FROM niveau WHERE id = '$id'";
    $result=$cnx->query($sql);
    $row = $result->fetch(PDO::FETCH_ASSOC);
    $niveau = $row['niveau'];


    $sql = "INSERT INTO modelecompetence (niveauMin,ponderation, libelléModele, libellecompetence) VALUES ('$niveau','$ponderation', '$modeleName','$competence')";
    $cnx->query($sql);

    $counter = $_POST['counter'];
    if($counter > 1) {
        for($i = 1; $i <= $counter; $i++) {
            $comp = 'competence_' . $i;
            $niveau = 'niveau_' . $i;
            $ponderation = 'ponderation_' . $i;  

            if(isset($_POST[$niveau]) && isset($_POST[$ponderation]) && isset($_POST[$comp])) {
                $ponderation = $_POST[$ponderation];
                $comp= $_POST[$comp];
                $id= $_POST[$niveau];
                
                $sql="SELECT niveau FROM niveau WHERE id = '$id'";
                $result=$cnx->query($sql);
                $row = $result->fetch(PDO::FETCH_ASSOC);
                $nv = $row['niveau'];      

                $sql = "INSERT INTO modelecompetence (niveauMin, ponderation, libelléModele, libellecompetence) VALUES ('$nv', '$ponderation', '$modeleName', '$comp')";
                $cnx->query($sql);
            }
        }
    }


?>
<?php
}
?>