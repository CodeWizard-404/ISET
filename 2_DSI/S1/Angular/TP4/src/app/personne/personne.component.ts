import { Component, Input } from '@angular/core';
import { Personne } from '../personne';

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css']
})
export class PersonneComponent {
  @Input() name:string = 'name';
  @Input() age:number = 0;
  @Input('etud')statut!:boolean;
}
