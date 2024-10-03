import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pays } from 'src/app/entities/pays';
import { PaysService } from 'src/app/services/pays.service';

@Component({
  selector: 'app-selectedpays',
  templateUrl: './selectedpays.component.html',
  styleUrls: ['./selectedpays.component.css']
})
export class SelectedpaysComponent implements OnInit {
  selectedContinent: string = '';
  paysList: Pays[] = [];

  constructor(private route: ActivatedRoute, private paysService: PaysService) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.selectedContinent = params['continent'];
      this.loadPaysByContinent();
    });
  }

  loadPaysByContinent() {
    // this.paysService.getPaysByContinent(this.selectedContinent).subscribe((data) => {
    //   this.paysList = data;
    // });
  }
}


