function afficher() {

    with (document.f1) {
        for (i = 0; i < n1.length; i++) {
            if (n1[i].checked) {
                indice = n1[i].value;
            }
        }

        let indices = [];
        for (i = 0; i < n2.length; i++) {
            if (n2[i].checked) {
                indices.push(n2[i].value);

            }
        }

        let indicess = [];
        for (i = 0; i < aze.length; i++) {
            if (aze[i].selected) {
                indicess[i]=aze.options[i].value;
            }
        }

        contenu = text.value;

        alert(` text : ${contenu}
         radio  : ${indice}
         checkbox  : ${indices.join(", ")}
         option : ${indicess.join(", ")}`);
    }
}

