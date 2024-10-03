import { Component } from '@angular/core';

@Component({
  selector: 'app-personnages',
  templateUrl: './personnages.component.html',
  styleUrls: ['./personnages.component.css']
})
export class PersonnagesComponent {
  tabPersonnages = [
    {nom:'Donald',image:'assets/donald.png', nb:44, majeur:true},
    {nom:'Popey',image:'assets/popey.jpg', nb:16, majeur:true},
    {nom:'Sam',image:'assets/happy.jpg', nb:14, majeur:false }
    ];

    increaseSubscribers(i: number) {
      this.tabPersonnages[i].nb++; 
    }
}
