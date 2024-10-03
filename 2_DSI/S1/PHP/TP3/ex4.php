<?php
$s = $_POST['s'] ?? '';
$l = strlen($s);
$sp = $_POST['p'] ?? 0;
$sl = $_POST['l'] ?? 0;
$sub = substr($s, $sp, $sl);
$r = strrev($s);
?>

<!DOCTYPE html>
<html>
<head>
    <title>String Manipulation</title>
</head>
<body>
    <h1>String Manipulation</h1>
    <form method="post">
        <label>Enter a string: <input type="text" name="s" value="<?= $s ?>"></label>
        <input type="submit" value="Submit">
    </form>

    <p>Length of the string: <?= $l ?></p>

    <form method="post">
        <label>Start position: <input type="text" name="p" value="<?= $sp ?>"></label>
        <label>Substring length: <input type="text" name="l" value="<?= $sl ?>"></label>
        <input type="submit" value="Extract Substring">
    </form>

    <p>Extracted substring: <?= $sub ?></p>
    <p>Reversed string: <?= $r ?></p>
</body>
</html>
