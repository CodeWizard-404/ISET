import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './component/menu/menu.component';
import { PresenationComponent } from './component/presenation/presenation.component';
import { ListlivreComponent } from './component/listlivre/listlivre.component';
import { AboutusComponent } from './component/aboutus/aboutus.component';
import { ErrorComponent } from './component/error/error.component';
import { SelectdLivreComponent } from './component/selectd-livre/selectd-livre.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    PresenationComponent,
    ListlivreComponent,
    AboutusComponent,
    ErrorComponent,
    SelectdLivreComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
