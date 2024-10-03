x = 82;
y = 2002;
do {
    x =prompt("Le numero du mois : ", x);
} while ((x < 1) || (x > 12));
x=parseInt(x);
do {
    y =prompt("Le numero de l'annee : ", y);
} while ((y < 1000) || (y > 3000));
y=parseInt(y);
let z=0;
let a=0;
function bisextile(a) {
    if ((a%400)==0) {
        return true;
    } else if(((a%100)!=0)&&((a%4)==0)){
        return false;
    }
}
switch (x) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12: z=31;
        break;
    case 4:
    case 6:
    case 9:
    case 11: z=30;
        break;
    case 2: {if (bisextile(y)){z=29}else{z=28}};
        break;
}

document.write(`le nombre de jours du mois ${x} de l'annee ${y} est : ${z}`);