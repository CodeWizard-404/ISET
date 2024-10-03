import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pays } from 'src/app/entities/pays';
import { PaysService } from 'src/app/services/pays.service';

@Component({
  selector: 'app-listpays',
  templateUrl: './listpays.component.html',
  styleUrls: ['./listpays.component.css'],
})
export class ListpaysComponent implements OnInit {
  paysList: Pays[] = [];

  constructor(private paysService: PaysService, private router: Router) {}

  ngOnInit(): void {
    this.loadPays();
  }

  loadPays() {
    this.paysService.getPays().subscribe((data) => (this.paysList = data));
  }

  showSelectedPays(continent: string) {
    this.router.navigate(['/countries/selectedpays'], { queryParams: { continent: continent } });
  }
}
