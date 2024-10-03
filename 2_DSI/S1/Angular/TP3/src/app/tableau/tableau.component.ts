import { Component } from '@angular/core';

@Component({
  selector: 'app-tableau',
  templateUrl: './tableau.component.html',
  styleUrls: ['./tableau.component.css']
})
export class TableauComponent {
  tab=[15,46,0,89,80];
   onPostion(x: number ,a:number) {
    console.log(x+" a pour postion "+ a);
  }
}
