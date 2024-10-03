import { Component,OnInit } from '@angular/core';
import { Employe } from '../Employe';
import { EmployeService } from '../employe.service';

@Component({
  selector: 'app-suppemployes',
  templateUrl: './suppemployes.component.html',
  styleUrls: ['./suppemployes.component.css']
})
export class SuppemployesComponent {
  lesemployes:Employe[]=[];
  constructor(private employeService:EmployeService){};
  ngOnInit():void{
    this.lesemployes=this.employeService.getEmplyes();
  }
  supprimerPremierEmploye() {
    this.employeService.deleteFirstEmploye();
  }
}
