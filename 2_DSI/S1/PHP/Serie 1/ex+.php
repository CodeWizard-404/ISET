<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Calcule Age </h1>
    <form method="POST">
        <label for="dob">Date e naissance:</label>
        <input type="date" name="dob" id="dob">
        <input type="submit" name="calculate" value="Calculate Age">
    </form>

    <?php
    if (isset($_POST['calculate'])) {
        $dob = $_POST['dob'];

        $today = new DateTime();
        $birthdate = new DateTime($dob);
        $age = $today->diff($birthdate)->y;

        echo "<p>Age: $age ans</p>";
    }
    ?>
</body>
</html>
