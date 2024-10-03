import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListpersonnesComponent } from './listpersonnes/listpersonnes.component';
import { PersonneComponent } from './personne/personne.component';
import { UnepersonneComponent } from './unepersonne/unepersonne.component';
import { TP4EXComponent } from './tp4-ex/tp4-ex.component';
import { ListPizzaComponent } from './list-pizza/list-pizza.component';
import { PizzaComponent } from './pizza/pizza.component';

@NgModule({
  declarations: [
    AppComponent,
    ListpersonnesComponent,
    PersonneComponent,
    UnepersonneComponent,
    TP4EXComponent,
    ListPizzaComponent,
    PizzaComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
