
<?php    $host = 'localhost';
    $dbname = 'systeme_de_recrutement';
    $username = 'root';
    $password = '';  
    try{
        $cnx= new PDO('mysql:host='.$host.';dbname='.$dbname,$username,$password);
    }
    catch(Exception $e){
        echo 'prob de cnx à la bd';
    }
?>