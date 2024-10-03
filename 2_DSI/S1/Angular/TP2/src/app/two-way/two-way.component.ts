import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
 imports: [
 BrowserModule,
 FormsModule
 ]
@Component({
  selector: 'app-two-way',
  templateUrl: './two-way.component.html',
  styles: [
  ]
})
export class TwoWayComponent {
  message:string ="DSI";
}
