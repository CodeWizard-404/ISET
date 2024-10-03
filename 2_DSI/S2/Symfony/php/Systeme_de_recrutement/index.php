<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<form method="post" action="">
        <table>
            <tr><td>Login :</td> <td><input type="text" name="login" required></td></tr> 
            <tr><td>Password :</td> <td><input type="password" name="pwd" required><br/></td></tr>
            <tr><td><input type="submit" value="Sign In" name="ok"></td></tr>
        </table>
    </form>
    <?php 
    include ("bd/connexion.php");
    if (isset($_POST['ok'])){
        $login=$_POST['login'];
        $pwd=$_POST['pwd'];
        $req="SELECT * FROM recruteur WHERE login = '$login' AND mdp = '$pwd' AND activé = '1'";
        $res=$cnx->query($req);
        if($res && $res->rowCount()==1){  
            Session_start();
            $_SESSION['ok']="ok";
            $enreg=$res->fetch(PDO::FETCH_ASSOC);
            $_SESSION["user"]=$enreg["login"];
            $_SESSION["password"]=$enreg["mdp"];
            if($enreg['role'] == 'admin'){
                echo"<script> document.location.href=\"dashboardAdmin.php\" </script>";
            }
            else{
                echo"<script> document.location.href=\"dashboardRecru.php\" </script>";
            }
        }
        else{
            echo "Echec! Réesssayer";
            echo"<script> document.location.href=\"index.php\" </script>";	
        } 
    }
?>
</body>
</html>