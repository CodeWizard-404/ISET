import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PresenationComponent } from './presenation.component';

describe('PresenationComponent', () => {
  let component: PresenationComponent;
  let fixture: ComponentFixture<PresenationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PresenationComponent]
    });
    fixture = TestBed.createComponent(PresenationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
