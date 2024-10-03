import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelephoneComponent } from './telephone.component';

describe('TelephoneComponent', () => {
  let component: TelephoneComponent;
  let fixture: ComponentFixture<TelephoneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TelephoneComponent]
    });
    fixture = TestBed.createComponent(TelephoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
