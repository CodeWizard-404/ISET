import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccueilComponent } from './app1/accueil/accueil.component';
import { ContactComponent } from './app1/contact/contact.component';
import { ErreurComponent } from './app1/erreur/erreur.component';
import { MenuComponent } from './app1/menu/menu.component';
import { VetementsComponent } from './app1/clothes/vetements/vetements.component';
import { ChaussuresComponent } from './app1/shoes/chaussures/chaussures.component';
import { EteComponent } from './app1/clothes/ete/ete.component';
import { HiverComponent } from './app1/clothes/hiver/hiver.component';
import { BebesComponent } from './app1/shoes/bebes/bebes.component';
import { FemmesComponent } from './app1/shoes/femmes/femmes.component';
import { HommesComponent } from './app1/shoes/hommes/hommes.component';
import { AutentifComponent } from './app2/autentif/autentif.component';
import { DashboardComponent } from './app2/dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    ContactComponent,
    ErreurComponent,
    MenuComponent,
    VetementsComponent,
    ChaussuresComponent,
    EteComponent,
    HiverComponent,
    BebesComponent,
    FemmesComponent,
    HommesComponent,
    AutentifComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
