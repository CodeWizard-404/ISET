import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonnagesFormatesComponent } from './personnages-formates.component';

describe('PersonnagesFormatesComponent', () => {
  let component: PersonnagesFormatesComponent;
  let fixture: ComponentFixture<PersonnagesFormatesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonnagesFormatesComponent]
    });
    fixture = TestBed.createComponent(PersonnagesFormatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
