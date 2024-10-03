import { Component } from '@angular/core';

@Component({
  selector: 'app-property-binding',
  templateUrl: './property-binding.component.html',
  styles: [
  ]
})
export class PropertyBindingComponent {
  titre:string ="Property Binding";
  nom:string ="Test";
  actif:boolean = false;
  taille:number = 50;
}
