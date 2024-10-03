
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
	include('db_config.php');
	$query = "SELECT * FROM niveau WHERE libelleCompetence = '".$_POST['libelleCompetence']."'";
	$result = $cnx->query($query);
	echo '<option value="">Select niveau</option>'; 
	while ($row = $result->fetch(PDO::FETCH_ASSOC)) {
		echo '<option value="'.$row['id'].'">'.$row['niveau'].'</option>'; 
	}
?>
<?php
}
?>