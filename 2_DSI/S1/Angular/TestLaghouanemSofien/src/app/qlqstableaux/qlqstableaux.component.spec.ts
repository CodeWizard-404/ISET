import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QlqstableauxComponent } from './qlqstableaux.component';

describe('QlqstableauxComponent', () => {
  let component: QlqstableauxComponent;
  let fixture: ComponentFixture<QlqstableauxComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [QlqstableauxComponent]
    });
    fixture = TestBed.createComponent(QlqstableauxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
