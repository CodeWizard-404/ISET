<?php
    include ("../bd/connexion.php");
    $competence = $_POST['competence'];
    $desc = $_POST['desc'];
    try{
        $exists=$cnx->query("SELECT * from competence where libelleCompetence='$competence'");
        if ($exists->rowCount() == 0){
            $sql = "INSERT INTO competence (libelleCompetence, description) VALUES ('$competence', '$desc',true)";
            $cnx->query($sql);
        
        
            $nv = $_POST['niveau'];
            $desc = $_POST['description'];
            $note = $_POST['note'];
            $sql = "INSERT INTO niveau (niveau, description,note, libelleCompetence) VALUES ('$nv', '$desc','$note','$competence')";
            $cnx->query($sql);
        
            $counter = $_POST['counter'];
            if($counter > 1) {
                for($i = 1; $i <= $counter; $i++) {
                    $niveau = 'niveau_' . $i;
                    $description = 'description_' . $i;
                    $note = 'note_' . $i;
        
                    if(isset($_POST[$niveau]) && isset($_POST[$description]) && isset($_POST[$note])) {
                        $niveau = $_POST[$niveau];
                        $description = $_POST[$description];
                        $note = $_POST[$note];
                        $sql = "INSERT INTO niveau (niveau, description, note, libelleCompetence) VALUES ('$niveau', '$description', '$note', '$competence')";
                        $cnx->query($sql);
                    }
                }
            }
            header("location:afficherCompetence.php");
        }else{
            echo "<script>alert('competences exite deja');</script>";

        }
    }catch (PDOException $e) {
        echo "";
    }
    


?>
