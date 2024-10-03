import { Component, Input } from '@angular/core';
import { Livre } from 'src/app/classes/livre';
import { LivreService } from 'src/app/services/livre.service';

@Component({
  selector: 'app-listlivre',
  templateUrl: './listlivre.component.html',
  styleUrls: ['./listlivre.component.css']
})
export class ListlivreComponent {
  tablivre!:Livre[];
  constructor(private livreService:LivreService){}
  ngOnInit():void{
    this.tablivre = this.livreService.getLivre();
  }

}
