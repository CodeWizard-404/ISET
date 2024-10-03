import { Component } from '@angular/core';

@Component({
  selector: 'app-interpolation',
  templateUrl: './interpolation.component.html',
  styles: [
  ]
})
export class InterpolationComponent {
  titre :string = "Interpolation";
  nom :string = "Ahmed";
  age :number = 20;
  info(){
    return this.nom + " a pour age " + this.age + " ans.";
  }
}
