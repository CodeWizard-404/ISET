import { Component } from '@angular/core';

@Component({
  selector: 'app-telephone',
  templateUrl: './telephone.component.html',
  styleUrls: ['./telephone.component.css']
})
export class TelephoneComponent {
  telephone = {
    marque:"Huawei", 
    modele:"Y5 Prime",
    photo:"assets/huawei.jpg", 
    prix:450,
  };
  price(): boolean {
    return this.telephone.prix<700
  }
  Afficher(){
    alert("Téléphone "+this.telephone.modele+" au prix de "+this.telephone.prix+ " DT");
  }
}
