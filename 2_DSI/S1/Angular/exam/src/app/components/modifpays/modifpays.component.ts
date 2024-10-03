import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Continent } from 'src/app/entities/continent';
import { Pays } from 'src/app/entities/pays';
import { PaysService } from 'src/app/services/pays.service';

@Component({
  selector: 'app-modifpays',
  templateUrl: './modifpays.component.html',
  styleUrls: ['./modifpays.component.css']
})
export class ModifpaysComponent  implements OnInit {
  paysList: Pays[] = [];
  selectedPays: Pays | null = null;
  updateForm: FormGroup;

  continentList: Continent[] = Object.values(Continent);

  constructor(private paysService: PaysService, private fb: FormBuilder) {
    this.updateForm = this.fb.group({
      id: [null, Validators.required],
      capitale: ['', [Validators.required, Validators.pattern(/^[A-Z][a-z ]{1,}$/)]],
      continent: [null, Validators.required],
      population: [null, [Validators.required, Validators.min(1000)]]
    });
  }

  ngOnInit(): void {
    this.paysService.getPays().subscribe(data => {
      this.paysList = data;
    });
  }

  onCountryChange() {
    const selectedId = this.updateForm.get('id')?.value;
    //this.selectedPays = this.paysList.find(pays => pays.id === selectedId);
    this.populateForm();
  }

  populateForm() {
    if (this.selectedPays) {
      this.updateForm.patchValue({
        capitale: this.selectedPays.capitale,
        continent: this.selectedPays.continent,
        population: this.selectedPays.population
      });
    }
  }

  onSubmit() {
    if (this.updateForm.valid && this.selectedPays) {
      const updatedPays: Pays = {
        id: this.selectedPays.id,
        nom: this.selectedPays.nom,
        capitale: this.updateForm.get('capitale')?.value,
        drapeau: this.selectedPays.drapeau,
        continent: this.updateForm.get('continent')?.value,
        superficie: this.selectedPays.superficie,
        population: this.updateForm.get('population')?.value,
        royaume: this.selectedPays.royaume,
        langues: this.selectedPays.langues
      };

      this.paysService.updatePays(updatedPays.id, updatedPays).subscribe(() => {
      });
    }
  }

  clearForm() {
    this.updateForm.reset();
  }

  isFieldInvalid(fieldName: string): boolean {
    const control = this.updateForm.get(fieldName);
    return control ? control.invalid && control.touched : false;
  }
}
