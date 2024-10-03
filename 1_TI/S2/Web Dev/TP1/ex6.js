let x=" ";
let y=" ";
do {
    x=prompt("Note CC :","10");  
} while ((x<0)||(x>20));
do {
    y=prompt("Note Ex :","15");
} while ((x<0)||(x>20));
z1=parseFloat(x);
z2=parseFloat(y);
z3=z1*0.5+z2*0.5;

document.write(`<br><h3>Resultat d'un Etudiant</h3><br>`);
document.write(`Note NCC est <span class="c1">${z1}</span> et la note Nex est <span class="c1">${z2}</span> ta moyenne est : <span class="c1">${z3}</span><br>`);

if (z3<10) {
    document.write(`Vous etes Refuse`);
} else if (z3<12) {
    document.write(`Felicitation vous etes admis avec la mention passable`);
} else if (z3<15) {
    document.write(`Felicitation vous etes admis avec la mention Assez Bien`);
} else{
    document.write(`Felicitation vous etes admis avec la mention Bien`);
}