import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactComponent } from './components/contact/contact.component';
import { DashpaysComponent } from './components/dashpays/dashpays.component';
import { ErreurComponent } from './components/erreur/erreur.component';
import { HomeComponent } from './components/home/home.component';
import { ListpaysComponent } from './components/listpays/listpays.component';
import { ModifpaysComponent } from './components/modifpays/modifpays.component';
import { SelectedpaysComponent } from './components/selectedpays/selectedpays.component';
import { ThemenuComponent } from './components/themenu/themenu.component';
import { HttpClientModule } from '@angular/common/http';
import { SelectedPaysAsyncPipe } from './components/selectedpays/selected-pays-async.pipe';


@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    DashpaysComponent,
    ErreurComponent,
    HomeComponent,
    ListpaysComponent,
    ModifpaysComponent,
    SelectedpaysComponent,
    ThemenuComponent,
    SelectedPaysAsyncPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
