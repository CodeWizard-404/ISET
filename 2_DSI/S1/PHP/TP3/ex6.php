<?php
if (isset($_POST['input_string'])) {
    $inputString = $_POST['input_string'];
    $words = explode(' ', $inputString);
    $initials = "";

    foreach ($words as $word) {
        $initials .= strtoupper($word[0]);
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Initials Converter</title>
</head>
<body>
    <h1>Initials Converter</h1>
    <form method="post">
        <label for="input_string">Enter a string: </label>
        <input type="text" name="input_string" id="input_string">
        <input type="submit" value="Convert">
    </form>

    <?php if (isset($initials)): ?>
        <p>Input: <?= $inputString ?></p>
        <p>Initials: <?= $initials ?></p>
    <?php endif; ?>
</body>
</html>
