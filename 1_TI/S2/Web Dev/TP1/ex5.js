
let x=" ";
let y=" ";
x=prompt("Prix artcle 1 est :","1000");
y=prompt("Prix artcle 2 est :","500");
z1=parseFloat(x);
z2=parseFloat(y);

document.write(`Prix artcle 1 est : <span>${z1}</span><br>`);
document.write(`Prix artcle 2 est : <span>${z2}</span><br>`);
document.write(`Le total et : <span>${z1+z2}</span><br>`);

let z3=0;
if ((z1+z2)<=150) {
    document.write(`Le taux de remise est : <span>0%</span><br>`);
    z3=1;
} else if ((z1+z2)<=600) {
    document.write(`Le taux de remise est : <span>15%</span><br>`);
    z3=0.15;
} else if ((z1+z2)<=600) {
    document.write(`Le taux de remise est : <span>25%</span><br>`);
    z3=0.25;
} else{
    document.write(`Le taux de remise est : <span>35%</span><br>`);
    z3=0.35;
}

document.write(`Le prix net aprix remise est : <span>${(z1+z2)-((z1+z2)*z3)}</span>`);




