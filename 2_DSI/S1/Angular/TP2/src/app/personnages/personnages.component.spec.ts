import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonnagesComponent } from './personnages.component';

describe('PersonnagesComponent', () => {
  let component: PersonnagesComponent;
  let fixture: ComponentFixture<PersonnagesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonnagesComponent]
    });
    fixture = TestBed.createComponent(PersonnagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
