import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectdLivreComponent } from './selectd-livre.component';

describe('SelectdLivreComponent', () => {
  let component: SelectdLivreComponent;
  let fixture: ComponentFixture<SelectdLivreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SelectdLivreComponent]
    });
    fixture = TestBed.createComponent(SelectdLivreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
