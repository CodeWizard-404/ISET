import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppComponent } from "./app.component";
import { PremierComponent } from './premier/premier.component';
import { DeuxiemeComponent } from './deuxieme/deuxieme.component';
import { TroisiemeComponent } from './troisieme/troisieme.component';
import { QuateriemeComponent } from './MesComposants/quaterieme/quaterieme.component';

@NgModule({
  declarations: [AppComponent, PremierComponent, DeuxiemeComponent, TroisiemeComponent, QuateriemeComponent],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
