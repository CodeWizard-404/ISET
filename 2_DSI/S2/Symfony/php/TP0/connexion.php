<?php
require_once("dbconfig.php");
class Connexion
{	private static $instance;
	private $cnx=null;
	private function __construct()
	{	$dsn="mysql:host=".HOST.";dbname=".BASE;
		try
		{	$this->cnx = new PDO($dsn,USER,PASS);	}
		catch(PDOException $except)
		{	echo"Echec de la connexion",
                $except->getMessage();
			exit();	
            }	
}
	static function getInstance()
	{ if(!(self::$instance instanceof self))
		{self::$instance= new self(); 	}
		return self::$instance;
		}
	public function getConnexion()
	{	return $this->cnx; }
}
?>
