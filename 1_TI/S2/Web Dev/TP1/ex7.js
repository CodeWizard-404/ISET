let n = 5;
n = prompt("Le nombre des etudient : ", n);
n = parseInt(n);

let t = [];
function saisie(cpt) {
    do {
        note = prompt(`le Note de l'Etudient N${cpt + 1} :`, 10);
    } while ((note < 0) || (note > 20));
    note = parseFloat(note);
    return note;
}
function moy() {
    let s=0;
    for (x of t) {
        s += x;
    }
    return (s / n);
}
function max(){
    let mx=0;
    for(x of t){
        if(x>mx){
            mx=x;
        }
    }
    return mx;
}
function min(){
    let mn=20;
    for(x of t){
        if(x<mn){
            mn=x;
        }
    }
    return mn;
}
function affiche(){
    let i=0;
    for(x of t){
        i++;
        document.write(`${i}. ${x}<br>`);
    }
}
for (let i = 0; i < n; i++) {
    t[i] = saisie(i);
}
document.write(`PV des notes de la classe TI100<br><br>
<table>
    <tr>
        <td>Le nombre d'etudiants</td>
        <td>${n}</td>
    </tr>
    <tr>
        <td>La Liste des notes</td>
        <td>`);affiche();document.write(`</td>
    </tr>
    <tr>
        <td>La moyenne de la classe est</td>
        <td>${moy()}</td>
    </tr>
    <tr>
        <td>La meilleure note est</td>
        <td>${max()}</td>
    </tr>
    <tr>
        <td>La mauvaise note est</td>
        <td>${min()}</td>
    </tr>
</table>
`);





