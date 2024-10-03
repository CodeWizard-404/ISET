import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListmaterielComponent } from './listmateriel.component';

describe('ListmaterielComponent', () => {
  let component: ListmaterielComponent;
  let fixture: ComponentFixture<ListmaterielComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListmaterielComponent]
    });
    fixture = TestBed.createComponent(ListmaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
