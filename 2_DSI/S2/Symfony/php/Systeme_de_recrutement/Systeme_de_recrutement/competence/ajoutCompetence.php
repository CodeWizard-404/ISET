<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<form action="saveData.php" method="post">
    Competence:
    <input type="text" name="competence"> <br>
    description: 
    <input type="text" name="desc"> <br>
    <b>les niveaux de la competences:</b> 
    <div id="div">
        <!-- <label>niveau:</label> 
        <input type="text" name="niveau"> <br>
        <label>description:</label> <br>
        <textarea name="description" cols="30" rows="3"></textarea>
        <br>
        note:
        <input type="number" name="note"> -->
    </div>
    <button type="button" onclick="add()">creer un niveau </button><br>
    <button type="button" onclick="nvvv()">choix à partir des niveaux exisants </button><br>
    <input type="submit" name="ajout">
    <input type="hidden" name="counter" id="counter" value="1">
</form>

<script>
    function add() {
        var counterInput = document.getElementById('counter');
        var counter = parseInt(counterInput.value); 

        var p = document.createElement('p');
        p.innerHTML = 'niveau:';

        var p1 = document.createElement('p');
        p1.innerHTML = 'note:';

        var input = document.createElement('input');
        input.type = 'text';
        input.name = 'niveau_' + counter;

        var note = document.createElement('input');
        note.type = 'number';
        note.name = 'note_' + counter;

        pDesc = document.createElement('p');
        pDesc.innerHTML = "description";

        var textarea = document.createElement('textarea');
        textarea.name = 'description_' + counter;
        textarea.cols = '30';
        textarea.rows = '3';

        div.appendChild(p);
        div.appendChild(input);
        div.appendChild(pDesc);
        div.appendChild(textarea);
        div.appendChild(p1);
        div.appendChild(note);

        counter++; 
        counterInput.value = counter; 
    }
    function nvvv() {
    // Create select element
    var select = document.createElement("select");
    
    // Create and append option elements
    var options = ["A1", "A2", "B1", "B2", "B1", "B3", "beginner", "+", "-"];
    for (var i = 0; i < options.length; i++) {
        var option = document.createElement("option");
        option.text = options[i];
        select.add(option);
    }
    
    // Set default text
    var defaultOption = document.createElement("option");
    defaultOption.text = "Select Niveau";
    defaultOption.selected = true;
    defaultOption.disabled = true;
    select.add(defaultOption, 0);
    
    // Append select to the body or any other element you desire
    div.appendChild(select);
}
</script>

</body>
</html>
