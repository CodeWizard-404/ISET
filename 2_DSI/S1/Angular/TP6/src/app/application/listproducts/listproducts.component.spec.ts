import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListproductsComponent } from './listproducts.component';

describe('ListproductsComponent', () => {
  let component: ListproductsComponent;
  let fixture: ComponentFixture<ListproductsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListproductsComponent]
    });
    fixture = TestBed.createComponent(ListproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
