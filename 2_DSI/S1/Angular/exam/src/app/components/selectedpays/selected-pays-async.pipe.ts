import { Pipe, PipeTransform } from '@angular/core';
import { Pays } from 'src/app/entities/pays';
import { PaysService } from 'src/app/services/pays.service';


@Pipe({
  name: 'selectedPaysAsync',
  pure: false 
})
export class SelectedPaysAsyncPipe implements PipeTransform {
  constructor(private paysService: PaysService) {}

  transform(pays: Pays[] | null, continent: string | null): any {
    if (!pays || !continent) return [];

    //return this.paysService.getPaysByContinent(continent);
  }
}
