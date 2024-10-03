import { Component, Input } from '@angular/core';
import { Tableau } from '../tableau';

@Component({
  selector: 'app-tableau',
  templateUrl: './tableau.component.html',
  styleUrls: ['./tableau.component.css']
})
export class TableauComponent {
  @Input() tab!:Tableau;
}
