import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListemployesComponent } from './Application/listemployes/listemployes.component';
import { SuppemployesComponent } from './Application/suppemployes/suppemployes.component';

@NgModule({
  declarations: [
    AppComponent,
    ListemployesComponent,
    SuppemployesComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
