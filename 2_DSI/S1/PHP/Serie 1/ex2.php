<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        table {
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Pays</th>
            <th>Villes</th>
        </tr>
        <?php
        $tab1 = array(
            "France" => array("Paris", "Lyon", "Marseille", "Nantes", "Lille"),
            "Allemagne" => array("Berlin", "Hambourg", "Hanovre", "Munich", "Cologne"),
            "Espagne" => array("Madrid", "Bilbao", "Grenade", "Barcelone", "Séville")
        );

        foreach ($tab1 as $pays => $villes) {
            echo "<tr>";
            echo "<td rowspan='" . count($villes) . "'>$pays</td>";

            foreach ($villes as $index => $ville) {
                if ($index > 0) {
                    echo "<tr>"; 
                }
                echo "<td>$ville</td>";
            }
            echo "</tr>";
        }
        ?>
    </table>
</body>
</html>
