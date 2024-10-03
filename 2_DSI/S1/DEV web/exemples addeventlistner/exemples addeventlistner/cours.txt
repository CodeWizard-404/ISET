//On sélectionne le premier button et le premier div du document
let b1 = document.querySelector('button');
let d1 = document.querySelector('div');

//On utilise la méthode addEventListener pour gérer des évènements
b1.addEventListener('click', function(){alert('Bouton cliqué')});
d1.addEventListener('mouseover', function(){this.style.backgroundColor ='orange'});
d1.addEventListener('mouseover', function(){this.style.fontWeight ='bold'});
d1.addEventListener('mouseout', function(){this.style.backgroundColor='white'});
