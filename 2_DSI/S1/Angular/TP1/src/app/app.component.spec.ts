import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [AppComponent]
  }));

  it('should create the app', () => {
    var fixture = TestBed.createComponent(AppComponent);
    var app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'TP1'`, () => {
    var fixture = TestBed.createComponent(AppComponent);
    var app = fixture.componentInstance;
    expect(app.title).toEqual('TP1');
  });

  it('should render title', () => {
    var fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    var compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('TP1 app is running!');
  });
});
