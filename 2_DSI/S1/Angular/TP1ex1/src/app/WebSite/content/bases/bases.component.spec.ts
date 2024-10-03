import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasesComponent } from './bases.component';

describe('BasesComponent', () => {
  let component: BasesComponent;
  let fixture: ComponentFixture<BasesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BasesComponent]
    });
    fixture = TestBed.createComponent(BasesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
